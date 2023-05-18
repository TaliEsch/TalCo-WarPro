package org.TalCoWarPro.Objects.UniteDescriptor;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class UniteDescriptor {

    private static final AtomicInteger count = new AtomicInteger(0);
    private int referenceId;
    private String descriptor;
    private String nationalite;
    private String motherCountry;
    private String acknowUnitType;
    private String typeUnitFormation;
    private ArrayList<String> initialFlagSet;
    private Boolean useFollowCam;
    private Boolean stickToGround;
    private Boolean inGeoDb;
    private Boolean porteurMustBeVisible;
    private Boolean clampInWorld;
    private Boolean clampOutMap;
    private String relativeScanningPosition;
    private String lowAltitudeFlyingAltitude;
    private String nearGroundFlyingAltitude;
    private ArrayList<String> tTagsModuleDescriptor;
    private String experienceLevelsPackDescriptor;
    private Boolean canWinExperience;
    private String experienceGainBySecond;
    private String experienceMultiplierBonusOnKill;
    private String autoRevealType;
    private String unitConcealmentBonus;
    private String visionUnitType;
    private Boolean unitIsStealth;
    private Boolean hideFromDebug;
    private Boolean pickableObject;
    private String depiction;
    private String ghostDepiction;
    private String blackHoleIdentifier;
    private String gameplayBBoxBoneName;
    private String autoCoverRange;
    private String occupationRadius;
    private String terrainListMask;
    private String terrainList;
    private Boolean useTerrainsForEscape;
    private String weaponManagerDefault;
    private String weaponManagerSelection;
    private String suppressDamagesRegenRatio;
    private String suppressDamagesRegenRatioOutOfRange;
    private String stunDamagesRegen;
    private Boolean stunFreezesUnits;
    private String blindageProperties;
    private String armorDescriptorFront;
    private String armorDescriptorSides;
    private String armorDescriptorRear;
    private String armorDescriptorTop;
    private String maxSuppressionDamages;
    private String maxStunDamages;
    private String maxDamages;
    private Boolean killWhenDamagesReachMax;
    private String hitRollSize;
    private String hitRollECM;
    private Boolean autoOrientation;
    private Boolean skipCadavreCreation;
    private Boolean useTopArmorAgainstFire;
    private String physicalDamageLevelsPack;
    private String suppressDamageLevelsPack;
    private String stunDamageLevelsPack;
    private String dangerousness;
    private String moralLevel;
    private String maxSpeed;
    private String unitMovingType;
    private String pathfindType;
    private String preferredLayerMask;
    private String vitesseCombat;
    private String speedBonusOnRoad;
    private String maxAcceleration;
    private String maxDeceleration;
    private String tempsDemiTour;
    private String vehicleSubType;
    private String startTime;
    private String stopTime;
    private String rotationStartTime;
    private String rotationStopTime;
    private String fuelCapacity;
    private String fuelMoveDuration;
    private String opticsAltitudeConfig;
    private Boolean doesNotCountInScannerAbsoluteMaxRange;
    private String porteeVisionTBA;
    private String porteeVisionFOW;
    private String detectionTBA;
    private String porteeVision;
    private String porteeIdentification;
    private String opticalStrength;
    private String opticalStrengthAltitude;
    private Boolean unitDetectStealthUnit;
    private String specializedDetections;
    private String specializedOpticalStrengths;
    private String ignoreObstacles;
    private String identifyBaseProbability;
    private String timeBetweenEachIdentifyRoll;
    private String visibilityRuleDescriptor;
    private String distanceMultiplierRule;
    private String multiplicateurAPorteeMaximale;
    private String multiplicateurAPorteeMinimale;
    private String exposant;
    private String multiplicateurAPorteeMaximaleEnMouvement;
    private String multiplicateurAPorteeMinimaleEnMouvement;
    private String exposantEnMouvement;
    private Boolean isTransport;
    private String transportedTexture;
    private String transportedSoldier;
    private String timeToLoad;
    private String nbSeatsOccupied;
    private Boolean isTowable;
    private ArrayList<String> transporterCategories;
    private ArrayList<String> transportableTagSet;
    private String nbSeatsAvailable;
    private String wreckUnloadPhysicalDamageBonus;
    private String wreckUnloadSuppressDamageBonus;
    private String wreckUnloadStunDamageBonus;
    private String loadRadius;
    private String factory;
    private String productionTime;
    private String commandPoints;
    private String resourceTickets;
    private Boolean canAssist;
    private String assistRequestBroadcastRadius;
    private String distanceToFlee;
    private String maxDistanceForOffensiveReaction;
    private String maxDistanceForOffensiveReactionOnFlyingTarget;
    private String maxDistanceForEngagement;
    private ArrayList<String> searchedTagsInEngagementTarget;
    private String minimapDisplayTexture;
    private String minimapDisplayGhostTexture;
    private Boolean minimapDisplayIsAlwaysVisible;
    private Boolean minimapDisplayUseTeamColor;
    private Boolean minimapDisplayFollowUnitOrientation;
    private String validOrders;
    private String unlockableOrders;
    private String multiSelectionSortingOrder;
    private String unitName;
    private String identifiedTexture;
    private String identifiedTextureCommandNameTrigger;
    private String identifiedTextureAlterator;
    private ArrayList<String> identifiedTextureValues;
    private String defaultSpeciailtyToken;
    private String unidentifiedTexture;
    private String unidentifiedTextureCommandNameTrigger;
    private String unidentifiedTextureAlterator;
    private ArrayList<String> unidentifiedTextureTextureValues;
    private String positionHeightOffset;
    private String nbSoldiers;
    private String evacuationTime;
    private String travelDuration;
    private String unitAttackValue;
    private String unitDefenseValue;
    private String unitBonusXpPerLevelValue;
    private String unitRole;
    private ArrayList<String> specialtiesList;
    private String nameToken;
    private String infoPanelConfigurationToken;
    private String typeSpecificToken;
    private String realRoadSpeed;
    private Boolean isAce;
    private String upgradeFromUnit;
    private Boolean generateName;
    private String menuIconTexture;
    private String buttonTexture;
    private String countryTexture;
    private String typeStrategicCount;

    public UniteDescriptor(String descriptor, String nationalite, String motherCountry, String acknowUnitType,
                           String typeUnitFormation, ArrayList<String> initialFlagSet, Boolean useFollowCam,
                           Boolean stickToGround, Boolean inGeoDb, Boolean porteurMustBeVisible, Boolean clampInWorld,
                           Boolean clampOutMap, String relativeScanningPosition, String lowAltitudeFlyingAltitude,
                           String nearGroundFlyingAltitude, ArrayList<String> tTagsModuleDescriptor,
                           String experienceLevelsPackDescriptor, Boolean canWinExperience,
                           String experienceGainBySecond, String experienceMultiplierBonusOnKill,
                           String autoRevealType, String unitConcealmentBonus, String visionUnitType,
                           Boolean unitIsStealth, Boolean hideFromDebug, Boolean pickableObject, String depiction,
                           String ghostDepiction, String blackHoleIdentifier, String gameplayBBoxBoneName,
                           String autoCoverRange, String occupationRadius, String terrainListMask, String terrainList,
                           Boolean useTerrainsForEscape, String weaponManagerDefault, String weaponManagerSelection,
                           String suppressDamagesRegenRatio, String suppressDamagesRegenRatioOutOfRange,
                           String stunDamagesRegen, Boolean stunFreezesUnits, String blindageProperties,
                           String armorDescriptorFront, String armorDescriptorSides, String armorDescriptorRear,
                           String armorDescriptorTop, String maxSuppressionDamages, String maxStunDamages,
                           String maxDamages, Boolean killWhenDamagesReachMax, String hitRollSize, String hitRollECM,
                           Boolean autoOrientation, Boolean skipCadavreCreation, Boolean useTopArmorAgainstFire,
                           String physicalDamageLevelsPack, String suppressDamageLevelsPack, String stunDamageLevelsPack,
                           String dangerousness, String moralLevel, String maxSpeed, String unitMovingType,
                           String pathfindType, String preferredLayerMask, String vitesseCombat,
                           String speedBonusOnRoad, String maxAcceleration, String maxDeceleration,
                           String tempsDemiTour, String vehicleSubType, String startTime, String stopTime,
                           String rotationStartTime, String rotationStopTime, String fuelCapacity,
                           String fuelMoveDuration, String opticsAltitudeConfig,
                           Boolean doesNotCountInScannerAbsoluteMaxRange, String porteeVisionTBA,
                           String porteeVisionFOW, String detectionTBA, String porteeVision, String porteeIdentification,
                           String opticalStrength, String opticalStrengthAltitude, Boolean unitDetectStealthUnit,
                           String specializedDetections, String specializedOpticalStrengths, String ignoreObstacles,
                           String identifyBaseProbability, String timeBetweenEachIdentifyRoll,
                           String visibilityRuleDescriptor, String distanceMultiplierRule,
                           String multiplicateurAPorteeMaximale, String multiplicateurAPorteeMinimale, String exposant,
                           String multiplicateurAPorteeMaximaleEnMouvement, String multiplicateurAPorteeMinimaleEnMouvement,
                           String exposantEnMouvement, Boolean isTransport, String transportedTexture,
                           String transportedSoldier, String timeToLoad, String nbSeatsOccupied, Boolean isTowable,
                           ArrayList<String> transporterCategories, ArrayList<String> transportableTagSet, String nbSeatsAvailable,
                           String wreckUnloadPhysicalDamageBonus, String wreckUnloadSuppressDamageBonus,
                           String wreckUnloadStunDamageBonus, String loadRadius,String factory,
                           String productionTime, String commandPoints, String resourceTickets, Boolean canAssist,
                           String assistRequestBroadcastRadius, String distanceToFlee, String maxDistanceForOffensiveReaction,
                           String maxDistanceForOffensiveReactionOnFlyingTarget, String maxDistanceForEngagement,
                           ArrayList<String> searchedTagsInEngagementTarget, String minimapDisplayTexture,
                           String minimapDisplayGhostTexture, Boolean minimapDisplayIsAlwaysVisible,
                           Boolean minimapDisplayUseTeamColor, Boolean minimapDisplayFollowUnitOrientation,
                           String validOrders, String unlockableOrders, String multiSelectionSortingOrder,
                           String unitName, String identifiedTexture, String identifiedTextureCommandNameTrigger,
                           String identifiedTextureAlterator, ArrayList<String> identifiedTextureValues,
                           String defaultSpeciailtyToken, String unidentifiedTexture,
                           String unidentifiedTextureCommandNameTrigger, String unidentifiedTextureAlterator,
                           ArrayList<String> unidentifiedTextureTextureValues, String positionHeightOffset,
                           String nbSoldiers, String evacuationTime, String travelDuration, String unitAttackValue,
                           String unitDefenseValue, String unitBonusXpPerLevelValue, String unitRole,
                           ArrayList<String> specialtiesList, String nameToken, String infoPanelConfigurationToken,
                           String typeSpecificToken, String realRoadSpeed, Boolean isAce, String upgradeFromUnit,
                           Boolean generateName, String menuIconTexture, String buttonTexture, String countryTexture,
                           String typeStrategicCount) {
// Assign the constructor arguments to the class variables...
        this.descriptor = descriptor;
        this.nationalite = nationalite;
        this.motherCountry = motherCountry;
        this.acknowUnitType = acknowUnitType;
        this.typeUnitFormation = typeUnitFormation;
        this.initialFlagSet = initialFlagSet;
        this.useFollowCam = useFollowCam;
        this.stickToGround = stickToGround;
        this.inGeoDb = inGeoDb;
        this.porteurMustBeVisible = porteurMustBeVisible;
        this.clampInWorld = clampInWorld;
        this.clampOutMap = clampOutMap;
        this.relativeScanningPosition = relativeScanningPosition;
        this.lowAltitudeFlyingAltitude = lowAltitudeFlyingAltitude;
        this.nearGroundFlyingAltitude = nearGroundFlyingAltitude;
        this.tTagsModuleDescriptor = tTagsModuleDescriptor;
        this.experienceLevelsPackDescriptor = experienceLevelsPackDescriptor;
        this.canWinExperience = canWinExperience;
        this.experienceGainBySecond = experienceGainBySecond;
        this.experienceMultiplierBonusOnKill = experienceMultiplierBonusOnKill;
        this.autoRevealType = autoRevealType;
        this.unitConcealmentBonus = unitConcealmentBonus;
        this.visionUnitType = visionUnitType;
        this.unitIsStealth = unitIsStealth;
        this.hideFromDebug = hideFromDebug;
        this.pickableObject = pickableObject;
        this.depiction = depiction;
        this.ghostDepiction = ghostDepiction;
        this.blackHoleIdentifier = blackHoleIdentifier;
        this.gameplayBBoxBoneName = gameplayBBoxBoneName;
        this.autoCoverRange = autoCoverRange;
        this.occupationRadius = occupationRadius;
        this.terrainListMask = terrainListMask;
        this.terrainList = terrainList;
        this.useTerrainsForEscape = useTerrainsForEscape;
        this.weaponManagerDefault = weaponManagerDefault;
        this.weaponManagerSelection = weaponManagerSelection;
        this.suppressDamagesRegenRatio = suppressDamagesRegenRatio;
        this.suppressDamagesRegenRatioOutOfRange = suppressDamagesRegenRatioOutOfRange;
        this.stunDamagesRegen = stunDamagesRegen;
        this.stunFreezesUnits = stunFreezesUnits;
        this.blindageProperties = blindageProperties;
        this.armorDescriptorFront = armorDescriptorFront;
        this.armorDescriptorSides = armorDescriptorSides;
        this.armorDescriptorRear = armorDescriptorRear;
        this.armorDescriptorTop = armorDescriptorTop;
        this.maxSuppressionDamages = maxSuppressionDamages;
        this.maxStunDamages = maxStunDamages;
        this.maxDamages = maxDamages;
        this.killWhenDamagesReachMax = killWhenDamagesReachMax;
        this.hitRollSize = hitRollSize;
        this.hitRollECM = hitRollECM;
        this.autoOrientation = autoOrientation;
        this.skipCadavreCreation = skipCadavreCreation;
        this.useTopArmorAgainstFire = useTopArmorAgainstFire;
        this.physicalDamageLevelsPack = physicalDamageLevelsPack;
        this.suppressDamageLevelsPack = suppressDamageLevelsPack;
        this.stunDamageLevelsPack = stunDamageLevelsPack;
        this.dangerousness = dangerousness;
        this.moralLevel = moralLevel;
        this.maxSpeed = maxSpeed;
        this.unitMovingType = unitMovingType;
        this.pathfindType = pathfindType;
        this.preferredLayerMask = preferredLayerMask;
        this.vitesseCombat = vitesseCombat;
        this.speedBonusOnRoad = speedBonusOnRoad;
        this.maxAcceleration = maxAcceleration;
        this.maxDeceleration = maxDeceleration;
        this.tempsDemiTour = tempsDemiTour;
        this.vehicleSubType = vehicleSubType;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.rotationStartTime = rotationStartTime;
        this.rotationStopTime = rotationStopTime;
        this.fuelCapacity = fuelCapacity;
        this.fuelMoveDuration = fuelMoveDuration;
        this.opticsAltitudeConfig = opticsAltitudeConfig;
        this.doesNotCountInScannerAbsoluteMaxRange = doesNotCountInScannerAbsoluteMaxRange;
        this.porteeVisionTBA = porteeVisionTBA;
        this.porteeVisionFOW = porteeVisionFOW;
        this.detectionTBA = detectionTBA;
        this.porteeVision = porteeVision;
        this.porteeIdentification = porteeIdentification;
        this.opticalStrength = opticalStrength;
        this.opticalStrengthAltitude = opticalStrengthAltitude;
        this.unitDetectStealthUnit = unitDetectStealthUnit;
        this.specializedDetections = specializedDetections;
        this.specializedOpticalStrengths = specializedOpticalStrengths;
        this.ignoreObstacles = ignoreObstacles;
        this.identifyBaseProbability = identifyBaseProbability;
        this.timeBetweenEachIdentifyRoll = timeBetweenEachIdentifyRoll;
        this.visibilityRuleDescriptor = visibilityRuleDescriptor;
        this.distanceMultiplierRule = distanceMultiplierRule;
        this.multiplicateurAPorteeMaximale = multiplicateurAPorteeMaximale;
        this.multiplicateurAPorteeMinimale = multiplicateurAPorteeMinimale;
        this.exposant = exposant;
        this.multiplicateurAPorteeMaximaleEnMouvement = multiplicateurAPorteeMaximaleEnMouvement;
        this.multiplicateurAPorteeMinimaleEnMouvement = multiplicateurAPorteeMinimaleEnMouvement;
        this.exposantEnMouvement = exposantEnMouvement;
        this.isTransport = isTransport;
        this.transportedTexture = transportedTexture;
        this.transportedSoldier = transportedSoldier;
        this.timeToLoad = timeToLoad;
        this.nbSeatsOccupied = nbSeatsOccupied;
        this.isTowable = isTowable;
        this.transporterCategories = transporterCategories;
        this.transportableTagSet = transportableTagSet;
        this.nbSeatsAvailable = nbSeatsAvailable;
        this.wreckUnloadPhysicalDamageBonus = wreckUnloadPhysicalDamageBonus;
        this.wreckUnloadSuppressDamageBonus = wreckUnloadSuppressDamageBonus;
        this.wreckUnloadStunDamageBonus = wreckUnloadStunDamageBonus;
        this.loadRadius = loadRadius;
        this.factory = factory;
        this.productionTime = productionTime;
        this.commandPoints = commandPoints;
        this.resourceTickets = resourceTickets;
        this.canAssist = canAssist;
        this.assistRequestBroadcastRadius = assistRequestBroadcastRadius;
        this.distanceToFlee = distanceToFlee;
        this.maxDistanceForOffensiveReaction = maxDistanceForOffensiveReaction;
        this.maxDistanceForOffensiveReactionOnFlyingTarget = maxDistanceForOffensiveReactionOnFlyingTarget;
        this.maxDistanceForEngagement = maxDistanceForEngagement;
        this.searchedTagsInEngagementTarget = searchedTagsInEngagementTarget;
        this.minimapDisplayTexture = minimapDisplayTexture;
        this.minimapDisplayGhostTexture = minimapDisplayGhostTexture;
        this.minimapDisplayIsAlwaysVisible = minimapDisplayIsAlwaysVisible;
        this.minimapDisplayUseTeamColor = minimapDisplayUseTeamColor;
        this.minimapDisplayFollowUnitOrientation = minimapDisplayFollowUnitOrientation;
        this.validOrders = validOrders;
        this.unlockableOrders = unlockableOrders;
        this.multiSelectionSortingOrder = multiSelectionSortingOrder;
        this.unitName = unitName;
        this.identifiedTexture = identifiedTexture;
        this.identifiedTextureCommandNameTrigger = identifiedTextureCommandNameTrigger;
        this.identifiedTextureAlterator = identifiedTextureAlterator;
        this.identifiedTextureValues = identifiedTextureValues;
        this.defaultSpeciailtyToken = defaultSpeciailtyToken;
        this.unidentifiedTexture = unidentifiedTexture;
        this.unidentifiedTextureCommandNameTrigger = unidentifiedTextureCommandNameTrigger;
        this.unidentifiedTextureAlterator = unidentifiedTextureAlterator;
        this.unidentifiedTextureTextureValues = unidentifiedTextureTextureValues;
        this.positionHeightOffset = positionHeightOffset;
        this.nbSoldiers = nbSoldiers;
        this.evacuationTime = evacuationTime;
        this.travelDuration = travelDuration;
        this.unitAttackValue = unitAttackValue;
        this.unitDefenseValue = unitDefenseValue;
        this.unitBonusXpPerLevelValue = unitBonusXpPerLevelValue;
        this.unitRole = unitRole;
        this.specialtiesList = specialtiesList;
        this.nameToken = nameToken;
        this.infoPanelConfigurationToken = infoPanelConfigurationToken;
        this.typeSpecificToken = typeSpecificToken;
        this.realRoadSpeed = realRoadSpeed;
        this.isAce = isAce;
        this.upgradeFromUnit = upgradeFromUnit;
        this.generateName = generateName;
        this.menuIconTexture = menuIconTexture;
        this.buttonTexture = buttonTexture;
        this.countryTexture = countryTexture;
        this.typeStrategicCount = typeStrategicCount;
        referenceId = count.incrementAndGet();
    }

    public UniteDescriptor(int referenceId, String descriptor, String nationalite, String motherCountry, String acknowUnitType,
                           String typeUnitFormation, Boolean useFollowCam,
                           Boolean stickToGround, Boolean inGeoDb, Boolean porteurMustBeVisible, Boolean clampInWorld,
                           Boolean clampOutMap, String relativeScanningPosition, String lowAltitudeFlyingAltitude,
                           String nearGroundFlyingAltitude,
                           String experienceLevelsPackDescriptor, Boolean canWinExperience,
                           String experienceGainBySecond, String experienceMultiplierBonusOnKill,
                           String autoRevealType, String unitConcealmentBonus, String visionUnitType,
                           Boolean unitIsStealth, Boolean hideFromDebug, Boolean pickableObject, String depiction,
                           String ghostDepiction, String blackHoleIdentifier, String gameplayBBoxBoneName,
                           String autoCoverRange, String occupationRadius, String terrainListMask, String terrainList,
                           Boolean useTerrainsForEscape, String weaponManagerDefault, String weaponManagerSelection,
                           String suppressDamagesRegenRatio, String suppressDamagesRegenRatioOutOfRange,
                           String stunDamagesRegen, Boolean stunFreezesUnits, String blindageProperties,
                           String armorDescriptorFront, String armorDescriptorSides, String armorDescriptorRear,
                           String armorDescriptorTop, String maxSuppressionDamages, String maxStunDamages,
                           String maxDamages, Boolean killWhenDamagesReachMax, String hitRollSize, String hitRollECM,
                           Boolean autoOrientation, Boolean skipCadavreCreation, Boolean useTopArmorAgainstFire,
                           String physicalDamageLevelsPack, String suppressDamageLevelsPack, String stunDamageLevelsPack,
                           String dangerousness, String moralLevel, String maxSpeed, String unitMovingType,
                           String pathfindType, String preferredLayerMask, String vitesseCombat,
                           String speedBonusOnRoad, String maxAcceleration, String maxDeceleration,
                           String tempsDemiTour, String vehicleSubType, String startTime, String stopTime,
                           String rotationStartTime, String rotationStopTime, String fuelCapacity,
                           String fuelMoveDuration, String opticsAltitudeConfig,
                           Boolean doesNotCountInScannerAbsoluteMaxRange, String porteeVisionTBA,
                           String porteeVisionFOW, String detectionTBA, String porteeVision, String porteeIdentification,
                           String opticalStrength, String opticalStrengthAltitude, Boolean unitDetectStealthUnit,
                           String specializedDetections, String specializedOpticalStrengths, String ignoreObstacles,
                           String identifyBaseProbability, String timeBetweenEachIdentifyRoll,
                           String visibilityRuleDescriptor, String distanceMultiplierRule,
                           String multiplicateurAPorteeMaximale, String multiplicateurAPorteeMinimale, String exposant,
                           String multiplicateurAPorteeMaximaleEnMouvement, String multiplicateurAPorteeMinimaleEnMouvement,
                           String exposantEnMouvement, Boolean isTransport, String transportedTexture,
                           String transportedSoldier, String timeToLoad, String nbSeatsOccupied, Boolean isTowable,
                           String nbSeatsAvailable,
                           String wreckUnloadPhysicalDamageBonus, String wreckUnloadSuppressDamageBonus,
                           String wreckUnloadStunDamageBonus, String loadRadius, String factory,
                           String productionTime, String commandPoints, String resourceTickets, Boolean canAssist,
                           String assistRequestBroadcastRadius, String distanceToFlee, String maxDistanceForOffensiveReaction,
                           String maxDistanceForOffensiveReactionOnFlyingTarget, String maxDistanceForEngagement, String minimapDisplayTexture,
                           String minimapDisplayGhostTexture, Boolean minimapDisplayIsAlwaysVisible,
                           Boolean minimapDisplayUseTeamColor, Boolean minimapDisplayFollowUnitOrientation,
                           String validOrders, String unlockableOrders, String multiSelectionSortingOrder,
                           String unitName, String identifiedTexture, String identifiedTextureCommandNameTrigger,
                           String identifiedTextureAlterator,
                           String defaultSpeciailtyToken, String unidentifiedTexture,
                           String unidentifiedTextureCommandNameTrigger, String unidentifiedTextureAlterator,
                           String positionHeightOffset,
                           String nbSoldiers, String evacuationTime, String travelDuration, String unitAttackValue,
                           String unitDefenseValue, String unitBonusXpPerLevelValue, String unitRole,
                           String nameToken, String infoPanelConfigurationToken,
                           String typeSpecificToken, String realRoadSpeed, Boolean isAce, String upgradeFromUnit,
                           Boolean generateName, String menuIconTexture, String buttonTexture, String countryTexture,
                           String typeStrategicCount) {
// Assign the constructor arguments to the class variables...
        this.referenceId = referenceId;
        this.descriptor = descriptor;
        this.nationalite = nationalite;
        this.motherCountry = motherCountry;
        this.acknowUnitType = acknowUnitType;
        this.typeUnitFormation = typeUnitFormation;
        this.useFollowCam = useFollowCam;
        this.stickToGround = stickToGround;
        this.inGeoDb = inGeoDb;
        this.porteurMustBeVisible = porteurMustBeVisible;
        this.clampInWorld = clampInWorld;
        this.clampOutMap = clampOutMap;
        this.relativeScanningPosition = relativeScanningPosition;
        this.lowAltitudeFlyingAltitude = lowAltitudeFlyingAltitude;
        this.nearGroundFlyingAltitude = nearGroundFlyingAltitude;
        this.experienceLevelsPackDescriptor = experienceLevelsPackDescriptor;
        this.canWinExperience = canWinExperience;
        this.experienceGainBySecond = experienceGainBySecond;
        this.experienceMultiplierBonusOnKill = experienceMultiplierBonusOnKill;
        this.autoRevealType = autoRevealType;
        this.unitConcealmentBonus = unitConcealmentBonus;
        this.visionUnitType = visionUnitType;
        this.unitIsStealth = unitIsStealth;
        this.hideFromDebug = hideFromDebug;
        this.pickableObject = pickableObject;
        this.depiction = depiction;
        this.ghostDepiction = ghostDepiction;
        this.blackHoleIdentifier = blackHoleIdentifier;
        this.gameplayBBoxBoneName = gameplayBBoxBoneName;
        this.autoCoverRange = autoCoverRange;
        this.occupationRadius = occupationRadius;
        this.terrainListMask = terrainListMask;
        this.terrainList = terrainList;
        this.useTerrainsForEscape = useTerrainsForEscape;
        this.weaponManagerDefault = weaponManagerDefault;
        this.weaponManagerSelection = weaponManagerSelection;
        this.suppressDamagesRegenRatio = suppressDamagesRegenRatio;
        this.suppressDamagesRegenRatioOutOfRange = suppressDamagesRegenRatioOutOfRange;
        this.stunDamagesRegen = stunDamagesRegen;
        this.stunFreezesUnits = stunFreezesUnits;
        this.blindageProperties = blindageProperties;
        this.armorDescriptorFront = armorDescriptorFront;
        this.armorDescriptorSides = armorDescriptorSides;
        this.armorDescriptorRear = armorDescriptorRear;
        this.armorDescriptorTop = armorDescriptorTop;
        this.maxSuppressionDamages = maxSuppressionDamages;
        this.maxStunDamages = maxStunDamages;
        this.maxDamages = maxDamages;
        this.killWhenDamagesReachMax = killWhenDamagesReachMax;
        this.hitRollSize = hitRollSize;
        this.hitRollECM = hitRollECM;
        this.autoOrientation = autoOrientation;
        this.skipCadavreCreation = skipCadavreCreation;
        this.useTopArmorAgainstFire = useTopArmorAgainstFire;
        this.physicalDamageLevelsPack = physicalDamageLevelsPack;
        this.suppressDamageLevelsPack = suppressDamageLevelsPack;
        this.stunDamageLevelsPack = stunDamageLevelsPack;
        this.dangerousness = dangerousness;
        this.moralLevel = moralLevel;
        this.maxSpeed = maxSpeed;
        this.unitMovingType = unitMovingType;
        this.pathfindType = pathfindType;
        this.preferredLayerMask = preferredLayerMask;
        this.vitesseCombat = vitesseCombat;
        this.speedBonusOnRoad = speedBonusOnRoad;
        this.maxAcceleration = maxAcceleration;
        this.maxDeceleration = maxDeceleration;
        this.tempsDemiTour = tempsDemiTour;
        this.vehicleSubType = vehicleSubType;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.rotationStartTime = rotationStartTime;
        this.rotationStopTime = rotationStopTime;
        this.fuelCapacity = fuelCapacity;
        this.fuelMoveDuration = fuelMoveDuration;
        this.opticsAltitudeConfig = opticsAltitudeConfig;
        this.doesNotCountInScannerAbsoluteMaxRange = doesNotCountInScannerAbsoluteMaxRange;
        this.porteeVisionTBA = porteeVisionTBA;
        this.porteeVisionFOW = porteeVisionFOW;
        this.detectionTBA = detectionTBA;
        this.porteeVision = porteeVision;
        this.porteeIdentification = porteeIdentification;
        this.opticalStrength = opticalStrength;
        this.opticalStrengthAltitude = opticalStrengthAltitude;
        this.unitDetectStealthUnit = unitDetectStealthUnit;
        this.specializedDetections = specializedDetections;
        this.specializedOpticalStrengths = specializedOpticalStrengths;
        this.ignoreObstacles = ignoreObstacles;
        this.identifyBaseProbability = identifyBaseProbability;
        this.timeBetweenEachIdentifyRoll = timeBetweenEachIdentifyRoll;
        this.visibilityRuleDescriptor = visibilityRuleDescriptor;
        this.distanceMultiplierRule = distanceMultiplierRule;
        this.multiplicateurAPorteeMaximale = multiplicateurAPorteeMaximale;
        this.multiplicateurAPorteeMinimale = multiplicateurAPorteeMinimale;
        this.exposant = exposant;
        this.multiplicateurAPorteeMaximaleEnMouvement = multiplicateurAPorteeMaximaleEnMouvement;
        this.multiplicateurAPorteeMinimaleEnMouvement = multiplicateurAPorteeMinimaleEnMouvement;
        this.exposantEnMouvement = exposantEnMouvement;
        this.isTransport = isTransport;
        this.transportedTexture = transportedTexture;
        this.transportedSoldier = transportedSoldier;
        this.timeToLoad = timeToLoad;
        this.nbSeatsOccupied = nbSeatsOccupied;
        this.isTowable = isTowable;
        this.nbSeatsAvailable = nbSeatsAvailable;
        this.wreckUnloadPhysicalDamageBonus = wreckUnloadPhysicalDamageBonus;
        this.wreckUnloadSuppressDamageBonus = wreckUnloadSuppressDamageBonus;
        this.wreckUnloadStunDamageBonus = wreckUnloadStunDamageBonus;
        this.loadRadius = loadRadius;
        this.factory = factory;
        this.productionTime = productionTime;
        this.commandPoints = commandPoints;
        this.resourceTickets = resourceTickets;
        this.canAssist = canAssist;
        this.assistRequestBroadcastRadius = assistRequestBroadcastRadius;
        this.distanceToFlee = distanceToFlee;
        this.maxDistanceForOffensiveReaction = maxDistanceForOffensiveReaction;
        this.maxDistanceForOffensiveReactionOnFlyingTarget = maxDistanceForOffensiveReactionOnFlyingTarget;
        this.maxDistanceForEngagement = maxDistanceForEngagement;
        this.minimapDisplayTexture = minimapDisplayTexture;
        this.minimapDisplayGhostTexture = minimapDisplayGhostTexture;
        this.minimapDisplayIsAlwaysVisible = minimapDisplayIsAlwaysVisible;
        this.minimapDisplayUseTeamColor = minimapDisplayUseTeamColor;
        this.minimapDisplayFollowUnitOrientation = minimapDisplayFollowUnitOrientation;
        this.validOrders = validOrders;
        this.unlockableOrders = unlockableOrders;
        this.multiSelectionSortingOrder = multiSelectionSortingOrder;
        this.unitName = unitName;
        this.identifiedTexture = identifiedTexture;
        this.identifiedTextureCommandNameTrigger = identifiedTextureCommandNameTrigger;
        this.identifiedTextureAlterator = identifiedTextureAlterator;
        this.defaultSpeciailtyToken = defaultSpeciailtyToken;
        this.unidentifiedTexture = unidentifiedTexture;
        this.unidentifiedTextureCommandNameTrigger = unidentifiedTextureCommandNameTrigger;
        this.unidentifiedTextureAlterator = unidentifiedTextureAlterator;
        this.positionHeightOffset = positionHeightOffset;
        this.nbSoldiers = nbSoldiers;
        this.evacuationTime = evacuationTime;
        this.travelDuration = travelDuration;
        this.unitAttackValue = unitAttackValue;
        this.unitDefenseValue = unitDefenseValue;
        this.unitBonusXpPerLevelValue = unitBonusXpPerLevelValue;
        this.unitRole = unitRole;
        this.nameToken = nameToken;
        this.infoPanelConfigurationToken = infoPanelConfigurationToken;
        this.typeSpecificToken = typeSpecificToken;
        this.realRoadSpeed = realRoadSpeed;
        this.isAce = isAce;
        this.upgradeFromUnit = upgradeFromUnit;
        this.generateName = generateName;
        this.menuIconTexture = menuIconTexture;
        this.buttonTexture = buttonTexture;
        this.countryTexture = countryTexture;
        this.typeStrategicCount = typeStrategicCount;
    }


}
