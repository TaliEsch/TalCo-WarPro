DROP DATABASE IF EXISTS WarPro;
CREATE DATABASE WarPro;
USE WarPro;

CREATE TABLE `uniteDescriptor` (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       descriptor VARCHAR(255),
                       nationalite VARCHAR(255),
                       motherCountry VARCHAR(255),
                       acknowUnitType VARCHAR(255),
                       typeUnitFormation VARCHAR(255),
                       useFollowCam TINYINT(1),
                       stickToGround TINYINT(1),
                       inGeoDb TINYINT(1),
                       porteurMustBeVisible TINYINT(1),
                       clampInWorld TINYINT(1),
                       clampOutMap TINYINT(1),
                       relativeScanningPosition VARCHAR(255),
                       lowAltitudeFlyingAltitude VARCHAR(255),
                       nearGroundFlyingAltitude VARCHAR(255),
                       experienceLevelsPackDescriptor VARCHAR(255),
                       canWinExperience TINYINT(1),
                       experienceGainBySecond VARCHAR(255),
                       experienceMultiplierBonusOnKill VARCHAR(255),
                       autoRevealType VARCHAR(255),
                       unitConcealmentBonus VARCHAR(255),
                       visionUnitType VARCHAR(255),
                       unitIsStealth TINYINT(1),
                       hideFromDebug TINYINT(1),
                       pickableObject TINYINT(1),
                       depiction VARCHAR(255),
                       ghostDepiction VARCHAR(255),
                       blackHoleIdentifier VARCHAR(255),
                       gameplayBBoxBoneName VARCHAR(255),
                       autoCoverRange VARCHAR(255),
                       occupationRadius VARCHAR(255),
                       terrainListMask VARCHAR(255),
                       terrainList VARCHAR(255),
                       useTerrainsForEscape TINYINT(1),
                       weaponManagerDefault VARCHAR(255),
                       weaponManagerSelection VARCHAR(255),
                       suppressDamagesRegenRatio VARCHAR(255),
                       suppressDamagesRegenRatioOutOfRange VARCHAR(255),
                       stunDamagesRegen VARCHAR(255),
                       stunFreezesUnits TINYINT(1),
                       blindageProperties VARCHAR(255),
                       armorDescriptorFront VARCHAR(255),
                       armorDescriptorSides VARCHAR(255),
                       armorDescriptorRear VARCHAR(255),
                       armorDescriptorTop VARCHAR(255),
                       maxSuppressionDamages VARCHAR(255),
                       maxStunDamages VARCHAR(255),
                       maxDamages VARCHAR(255),
                       killWhenDamagesReachMax TINYINT(1),
                       hitRollSize VARCHAR(255),
                       hitRollECM VARCHAR(255),
                       autoOrientation TINYINT(1),
                       skipCadavreCreation TINYINT(1),
                       useTopArmorAgainstFire TINYINT(1),
                       physicalDamageLevelsPack VARCHAR(255),
                       suppressDamageLevelsPack VARCHAR(255),
                       stunDamageLevelsPack VARCHAR(255),
                       dangerousness VARCHAR(255),
                       moralLevel VARCHAR(255),
                       maxSpeed VARCHAR(255),
                       unitMovingType VARCHAR(255),
                       pathfindType VARCHAR(255),
                       preferredLayerMask VARCHAR(255),
                       vitesseCombat VARCHAR(255),
                       speedBonusOnRoad VARCHAR(255),
                       maxAcceleration VARCHAR(255),
                       maxDeceleration VARCHAR(255),
                       tempsDemiTour VARCHAR(255),
                       vehicleSubType VARCHAR(255),
                       startTime VARCHAR(255),
                       stopTime VARCHAR(255),
                       rotationStartTime VARCHAR(255),
                       rotationStopTime VARCHAR(255),
                       fuelCapacity VARCHAR(255),
                       fuelMoveDuration VARCHAR(255),
                       opticsAltitudeConfig VARCHAR(255),
                       doesNotCountInScannerAbsoluteMaxRange TINYINT(1),
                       porteeVisionTBA VARCHAR(255),
                       porteeVisionFOW VARCHAR(255),
                       detectionTBA VARCHAR(255),
                       porteeVision VARCHAR(255),
                       porteeIdentification VARCHAR(255),
                       opticalStrength VARCHAR(255),
                       opticalStrengthAltitude VARCHAR(255),
                       unitDetectStealthUnit TINYINT(1),
                       specializedDetections VARCHAR(255),
                       specializedOpticalStrengths VARCHAR(255),
                       ignoreObstacles VARCHAR(255),
                       identifyBaseProbability VARCHAR(255),
                       timeBetweenEachIdentifyRoll VARCHAR(255),
                       visibilityRuleDescriptor VARCHAR(255),
                       distanceMultiplierRule VARCHAR(255),
                       multiplicateurAPorteeMaximale VARCHAR(255),
                       multiplicateurAPorteeMinimale VARCHAR(255),
                       exposant VARCHAR(255),
                       multiplicateurAPorteeMaximaleEnMouvement VARCHAR(255),
                       multiplicateurAPorteeMinimaleEnMouvement VARCHAR(255),
                       exposantEnMouvement VARCHAR(255),
                       isTransport TINYINT(1),
                       transportedTexture VARCHAR(255),
                       transportedSoldier VARCHAR(255),
                       timeToLoad VARCHAR(255),
                       nbSeatsOccupied VARCHAR(255),
                       isTowable TINYINT(1),
                       nbSeatsAvailable VARCHAR(255),
                       wreckUnloadPhysicalDamageBonus VARCHAR(255),
                       wreckUnloadSuppressDamageBonus VARCHAR(255),
                       wreckUnloadStunDamageBonus VARCHAR(255),
                       loadRadius VARCHAR(255),
                       factory VARCHAR(255),
                       productionTime VARCHAR(255),
                       commandPoints VARCHAR(255),
                       resourceTickets VARCHAR(255),
                       canAssist TINYINT(1),
                       assistRequestBroadcastRadius VARCHAR(255),
                       distanceToFlee VARCHAR(255),
                       maxDistanceForOffensiveReaction VARCHAR(255),
                       maxDistanceForOffensiveReactionOnFlyingTarget VARCHAR(255),
                       maxDistanceForEngagement VARCHAR(255),
                       searchedTagsInEngagementTarget VARCHAR(255),
                       minimapDisplayTexture VARCHAR(255),
                       minimapDisplayGhostTexture VARCHAR(255),
                       minimapDisplayIsAlwaysVisible TINYINT(1),
                       minimapDisplayUseTeamColor TINYINT(1),
                       minimapDisplayFollowUnitOrientation TINYINT(1),
                       validOrders VARCHAR(255),
                       unlockableOrders VARCHAR(255),
                       multiSelectionSortingOrder VARCHAR(255),
                       unitName VARCHAR(255),
                       identifiedTexture VARCHAR(255),
                       identifiedTextureCommandNameTrigger VARCHAR(255),
                       identifiedTextureAlterator VARCHAR(255),
                       defaultSpeciailtyToken VARCHAR(255),
                       unidentifiedTexture VARCHAR(255),
                       unidentifiedTextureCommandNameTrigger VARCHAR(255),
                       unidentifiedTextureAlterator VARCHAR(255),
                       positionHeightOffset VARCHAR(255),
                       nbSoldiers VARCHAR(255),
                       evacuationTime VARCHAR(255),
                       travelDuration VARCHAR(255),
                       unitAttackValue VARCHAR(255),
                       unitDefenseValue VARCHAR(255),
                       unitBonusXpPerLevelValue VARCHAR(255),
                       unitRole VARCHAR(255),
                       nameToken VARCHAR(255),
                       infoPanelConfigurationToken VARCHAR(255),
                       typeSpecificToken VARCHAR(255),
                       realRoadSpeed VARCHAR(255),
                       isAce TINYINT(1),
                       upgradeFromUnit VARCHAR(255),
                       generateName TINYINT(1),
                       menuIconTexture VARCHAR(255),
                       buttonTexture VARCHAR(255),
                       countryTexture VARCHAR(255),
                       typeStrategicCount VARCHAR(255)
);

CREATE TABLE unit_initial_flagset (
      unit_id INT,
      flag_value VARCHAR(255),
      FOREIGN KEY (unit_id) REFERENCES uniteDescriptor(id)
);

CREATE TABLE unit_ttags_module_descriptor (
      unit_id INT,
      ttag_module_descriptor_value VARCHAR(255),
      FOREIGN KEY (unit_id) REFERENCES uniteDescriptor(id)
);



CREATE TABLE unit_searched_tags_in_engagement_target (
     unit_id INT,
     searched_tag_value VARCHAR(255),
     FOREIGN KEY (unit_id) REFERENCES uniteDescriptor(id)
);

CREATE TABLE unit_identified_texture_values (

    unit_id INT,
    identified_texture_value VARCHAR(255),
    FOREIGN KEY (unit_id) REFERENCES uniteDescriptor(id)
);

CREATE TABLE unit_unidentified_texture_texture_values (
      unit_id INT,
      unidentified_texture_texture_value VARCHAR(255),
      FOREIGN KEY (unit_id) REFERENCES uniteDescriptor(id)
);

CREATE TABLE unit_specialties_list (
       unit_id INT,
       specialty_value VARCHAR(255),
       FOREIGN KEY (unit_id) REFERENCES uniteDescriptor(id)
);

CREATE TABLE unit_transporter_categories (
        unit_id INT,
        transporter_categories_value VARCHAR(255),
        FOREIGN KEY (unit_id) REFERENCES uniteDescriptor(id)
);

CREATE TABLE unit_transportable_tag_set (
        unit_id INT,
        transportable_tag_set_value VARCHAR(255),
        FOREIGN KEY (unit_id) REFERENCES uniteDescriptor(id)
);
