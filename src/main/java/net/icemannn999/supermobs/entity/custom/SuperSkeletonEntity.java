package net.icemannn999.supermobs.entity.custom;

import net.icemannn999.supermobs.entity.ai.SkeletonAttackGoal;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class SuperSkeletonEntity extends Monster {
    public static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(SuperSkeletonEntity.class, EntityDataSerializers.BOOLEAN);

    public SuperSkeletonEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide())
        {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 60;
            attackAnimationState.start(this.tickCount);
        } else
        {
            --attackAnimationTimeout;
        }

        if(!this.isAttacking())
        {
            attackAnimationState.stop();
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;

        if(this.getPose() == Pose.STANDING)
        {
            f = Math.min(pPartialTick * 6f, 1f);
        } else
        {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    public void setAttacking(boolean attacking)
    {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking()
    {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

        this.entityData.define(ATTACKING, false);
    }

    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.1));
        this.goalSelector.addGoal(1, new SkeletonAttackGoal(this, 1, true));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, IronGolem.class, true));
    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 40.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ATTACK_DAMAGE, 16.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.4);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getEntity() instanceof IronGolem) {
            amount *= 0.1F;
        }

        return super.hurt(source, amount);
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource pSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pSource, pLooting, pRecentlyHit);

        int bonesToDrop = (3 + this.random.nextInt(8));
        bonesToDrop += this.random.nextInt(pLooting + 1);
        this.spawnAtLocation(new ItemStack(Items.BONE, bonesToDrop));

        if (this.random.nextFloat() < 0.5 + 0.05 * pLooting) {
            this.spawnAtLocation(new ItemStack(Items.BONE_BLOCK, pLooting > 0 ? 2 : 1));
        }

//        if (this.random.nextFloat() < 0.02 + 0.1 * pLooting) {
//            this.spawnAtLocation(new ItemStack(ModItems.CUSTOM_GEM, 1));
//        }

        if (pSource.getEntity() instanceof Creeper creeper) {
            if (creeper.canDropMobsSkull()) {
                creeper.increaseDroppedSkulls();
                this.spawnAtLocation(Items.SKELETON_SKULL);
            }
        }
    }

    @Override
    protected void setItemSlotAndDropWhenKilled(EquipmentSlot pSlot, ItemStack pStack) {
        switch(pSlot)
        {
            case LEGS, FEET:
                break;
            default:
                this.setItemSlot(pSlot, pStack);
        }
    }

    @Override
    protected void populateDefaultEquipmentEnchantments(RandomSource pRandom, DifficultyInstance pDifficulty) {
//        if (pRandom.nextFloat() < (this.level().getDifficulty() == Difficulty.HARD ? 0.5F : 0.2F)) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
//        }
    }

    @Override
    protected void pickUpItem(ItemEntity pItemEntity) {
        ItemStack newItem = pItemEntity.getItem();

        if (this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()) {
            this.setItemSlot(EquipmentSlot.MAINHAND, newItem);
        } else if (this.getItemBySlot(EquipmentSlot.OFFHAND).isEmpty()) {
            this.setItemSlot(EquipmentSlot.OFFHAND, newItem);
        } else if (this.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
            this.setItemSlot(EquipmentSlot.HEAD, newItem);
        } else if (this.getItemBySlot(EquipmentSlot.CHEST).isEmpty()) {
            this.setItemSlot(EquipmentSlot.CHEST, newItem);
        }
        pItemEntity.discard();
    }

    @Override
    public boolean canHoldItem(ItemStack pStack) {
        return pStack.getItem() instanceof SwordItem || pStack.getItem() instanceof AxeItem || pStack.getItem() instanceof ShieldItem;
    }

    @Override
    public boolean wantsToPickUp(ItemStack pStack) {
        return pStack.getItem() instanceof SwordItem || pStack.getItem() instanceof AxeItem || pStack.getItem() instanceof ShieldItem;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.SKELETON_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource)
    {
        return SoundEvents.SKELETON_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.SKELETON_DEATH;
    }

    public @NotNull MobType getMobType()
    {
        return MobType.UNDEAD;
    }
}
