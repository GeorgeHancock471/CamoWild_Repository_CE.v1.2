This README.txt file was generated on 2022.12.07 by George Hancock


Contents:
1) General Information
2) Change Log / Feature Log
3) Printer Experiment Setup
4) ImageGA Recommendations


---------------------------------------------------------------------------------------------------------------------------------------------------------

1) GENERAL INFORMATION

---------------------------------------------------------------------------------------------------------------------------------------------------------

The following is a copy of the plugins for CamoEvo v1.2 - ImageJ 1.52 including the altered plugins and the features created for [insert paper title].

This includes all of the plugins used for the "Adaptive Genetic ALgorithms for Artifical Evolution of Visual Patterns Under Selection From Wild Predators" paper.

For more accessible versions of the [Printer Sheet] and [Measurent] plugins, please download CamoEvo V2.0+

	o. CamoWild_Plugins, just contains the altered plugins and the unique plugins to CamoWild. Too install download CamoEvo v1.2 and ImageJ and copy over the plugins to the plugins folder.
	
	o. CamoWild_Windows_(CE_v1.2), includes all the CamoWild plugins and CamoEvo v1.2 for the windows version of ImageJ.

	o. AlgorithmSettings, the ImageGA settings used for the avian and human experiments.

	o. gen_0_genes, the starting population genomes for the avian and human experiments.


In this .txt file you will find a list of all the altered and added files, and their respective functions. In addition to instructions for using the
CamoWild (Camouflage in the Wild) and CamoMeasure plugins.

---------------------------------------------------------------------------------------------------------------------------------------------------------

2) CHANGE LOG / FEATURE LOG

---------------------------------------------------------------------------------------------------------------------------------------------------------

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. Targets (Unique - Not Included 2.0)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Directory: plugins/1 CamoEvo/Targets/

	i) Oval_Game
	==========================
	
	The target shape, shader and alpha (gloss) layers used for the volunteer particiapnt evolution game. The shader opacity was set to 70%
	and the alpha opacity was set to 40%.


	ii) Oval_Print
	==========================
	
	The printed target shape use for the experiment with wild birds. Note the wider shape in order to allow for the print to be more easily 
	wrapped to the printed targets. There is no shader or alpha layer applied to these targets.NOTE, as the shape functions as a mask, it does 
	not distort or stretch the shape.


	iii) Target_Settings.txt
	==========================
	
	The target shape settings, listing the pattern generation method, mask shape, target size, angle range and opacity and alpha applications.

	
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
2. Game Module (Modified - Not Included 2.0 )
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

For similar system in V2.0 see Grid spawning system.

Directory: plugins/2 CamoReq/GameModule/

	i) Psychophysics_Game
	==========================
	
	Added an additional target spawn method, "wild". This method will cause target to spawn in a 5x5 grid just like in the outdoor experiment.
	Note this system is only compatible with populations where the numPerSlide = 3000. For example Settings_Game, see below.

	TargetSize =	390px		( The size of the given target in either pixels [px] or cm [cm] )
	NumPerSlide =	3		( The number of targets shown per slide )
	Angles =	-180	180	( The range of angles the target can have )
	TimeOutTime = 	15000		( The maximum time per slide )
	SpawnMethod =	wild		( The target spawning method [random, L*a*b* nearest,  L*a*b* furthest] )
	CaptureMethod =	rank	( The method used to determine capture [click,response,left&right,rank] )
	TransitionMethod =	centre	( The method used to change between slides [centre,click,wait] )
	TrainingNumber =	0	( The number of dummy targets used at the beginning )
	Repeats =	1		( The number of repeats per individual )
	ClickLeeWay =	0.5		( The click leeway based on the size of the target [e.g. 0.5 = + 50%] )
	CropWidth =	3000		( The crop width CAN'T BE BIGGER THEN SOURCE IMAGE )
	CropHeight =	3000		( The crop height CAN'T BE BIGGER THEN SOURCE IMAGE  )
	CropMode = 	centre		( The crop location [centre or random]  )
	FailTrigger =	none		( Fail conditions other then time out [miss.{N}, react, miss/react] )
	TargetMod =	none		( runs imageJ script on target )
	ImageMod =	Shadow Wild	( runs imageJ script on whole image )


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
3. Mod Stimuli (Unique)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Directory: plugins/2 CamoReq/Mod_Stimuli/

	i) Drop_Shadow (Included in 2.0)
	=====================================
	
	Stimuli modifiers (ImageMod) are custom scripts that can be applied to the slides of CamoEvo. The drop shadow script adds a shadow
	by subtracting a region surrounding the target with adjustable: 

		X_offset - Number of pixels offset on the x axis
		Y_offset - Number of pixels offset on the y axis
		scale - How many pixels bigger the shadow should be expanded.
		power - The gradient of loss of intensity.
		intensity - the strength of the shadow.

	
	ii) Shadow_Wild (NOT in 2.0)
	======================================
	
	Runs the Drop Shadow script with the presets used for the participant experiment. 
	
	"x_offset=1, y_offset=1, scale=5, power=2, intensity=8"

	Values were picked by trial and error until the targets looked sensible.

	

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
4. Target_Gen (Unique NOT in 2.0)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Directory: plugins/2 CamoReq/Target_Gen/

	i) Generate_Wild
	==========================
	
	The pattern generation code used to create the stimuli for the computer experiment. This generation system is a copy of the animal
	pattern generation, though the countershading has been changed from a top-down circular gradient, to a centre-surround gradient
	matching the aspect ratio of the target.

	
	ii) Template_Wild
	==========================
	
	The decimal gene labels used by the wild pattern generator.

	

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
5. 3 CamoMeasures (Unique NOT in 2.0)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Directory: plugins/3 CamoMeasures/


NOTE: These plugins were created prior to the image analysis changes in CamoEvo V1.21+, as such many of these scripts are redundent.
We recommend using the batch image analysis plugins in  CamoEvo V2.0+.

	i) 0_Batch_Target_RNL
	==========================
	
	[REQUIRES] A population folder, with backgrounds and targets generated by the CamoEvo Game.

	When executed, this macro will generate RNL maps for each generation of a population that you selected.


	
	ii) 1_Batch_Compare_RNL
	==========================

	[REQUIRES] Output from 0_Batch_target_RNL & an existing RNL colour map for one of the backgrounds the target evolved on.

	When executed, this macro will produce a table comparing the RNL colour difference of a selected population to a selected RNL colour map.


		
	iii) Measure_Stimi_ImageJ_LAB
	==============================

	[REQUIRES] A population folder, with backgrounds, targets and fitness values generated by the CamoEvo Game.

	When executed, this macro will produce a table of LAB mean and stdev values for the targets, local background (2x target scale) and whole 
	whole background of a selected population. In addition to measuring the targets GabRat (angles = 6; sigma = 3.0; gamma = 1.0; freq = 2.0;) ]
	of the target in the LAB channels, when against the background in the position it was spawned in.

	iv) Measure_Stimi_XYZ_Mean_Dev_GabRat
	=====================================

	[REQUIRES] A population folder, with backgrounds, targets and fitness values generated by the CamoEvo Game.

	When executed, this macro will produce a table of human XYZ mean and stdev values for the targets, local background (2x target scale) and whole 
	whole background of a selected population. In addition to measuring the targets GabRat (angles = 6; sigma = 3.0; gamma = 1.0; freq = 2.0;) ]
	of the target in the XYZ channels, when against the background in the position it was spawned in.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
6. 3 CamoWild (Unique Relabeled as /3 CamoPrint/ in 2.0)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Directory: plugins/3 CamoWild/


NOTE: These plugins were created prior to the changes in how additional pattern generators are stored and handled CamoEvo V1.20+, 
as such many of these scripts are redundent. We recommend using the CamoPrint plugins in CamoEvo V2.0+, which better integrates
these scripts with the CamoEvo toolbox.

These scripts were the ones used to run the outdoor experiment and as such are designed specifically for the table and marble run combination
used for the wild birds.


	i) 0)_Generate_Training_Patterns
	=================================
	
	[REQUIRES] Existing population folders from 1)_CamoWild_Setup, where GenPat_0 has been deleted

	When executed, this macro will generate the training patterns that were used when teaching the birds to associate the prey with food.
	These targets consisted of checkerboard patterns, where each square was a colour within the LAB space of the actual targets.


	
	ii) 0)_Regenerate_Prey_Patterns
	=================================
	[REQUIRES] Existing population folders from 1)_CamoWild_Setup, where GenPat_0 has been deleted

	When executed, this macro will recreate the prey patterns of the most recent generation, can be used to recreate the original patterns after 
	creating the training patterns.



	iii) 0)_Regenerate_Prey_Sheet
	==================================
	[REQUIRES] Existing population folders from 1)_CamoWild_Setup, where GenPat_0 has been deleted

	When executed, this macro will recreate the the prey sheet and re-order the target positions of a select population, for the newest generation.




	iv) 0)_Regenerate_Spawn_Locations
	==================================
	[REQUIRES] Existing population folders from 1)_CamoWild_Setup, where GenPat_0 has been deleted

	When executed, this macro will reate/replace the spawn positions .txt files of a select population, for the newest generation.



		
	v) 1)_CamoWild_Setup (MAIN SCRIPT)
	==================================

	This macro is used in order to more easily set up a series of populations for running camouflage printer experiments.

	Step 1, Select a location to store your populations

	Step 2, Choose how many treatments you wish to use, the number of repeats and whether repeats/treatments should share the same starting genome.
		(For our experiment we used 2 treatments, 2 repeats and a shared starting population).

	Step 3, Choose a colour space, number of individuals per group, grouping method, target size (px) and target shape.
		(For our experiment we used a custom space [0,100,-50,50,-10,70], 4 per group, random grouping, 400px and "Print_Oval")

	Step 4, Adjust the layout of the printer sheet, the number of targets per row, the px spacing and the number of copies per sheet.
		(For our experiment we used 7 per row, 60, 60 and 2 copies per sheet.)

	The script will then set up all of the populatiions and generate the print sheets for the first generation.

	As this was designed for our experiment. It will also create a "SpawnLocation" .txt file with target coorindates in the 5x5 grid.




	v) 2)_Population_Fitness_Submission (MAIN SCRIPT)
	====================================================

	This macro is used in order to enter the fitness values of each target and to create the next generation of targets, print sheets and spawn locations.

	Step 1, Select the population

	Step 2, Enter the fitness values for all of the targets, using the name assigned to it on the print sheet.




	vi) AlgorithmSettings
	====================================================

	The default algorithm settings used by the CamoWild scripts




	vii) Colour_Space_Modifier
	====================================================

	Modifies the LAB ranges of the targets, this script is run as a part of 1)_CamoWild_Setup




	viii) Create_Generation
	====================================================

	Creates the first generation, this script is run as a part of 1)_CamoWild_Setup



	ix) Edit_Algorithm_Wild
	====================================================

	Allows you to edit the default settings used by CamoWild, independently from CamoEvo.



	x) Generate_Prey_Patterns
	====================================================

	The pattern generation script for CamoWild.


	xi) Generate_Prey_Sheet
	====================================================

	Creates the prey sheet, target relabeled IDs and SpawnLocations.txts


	xii) Genotype_Template
	====================================================

	The genotype for the pattern generator.


	xiii) PopLocation
	====================================================

	Stores the directory of the currently being used population.

	

	xiv) PopulationTemplate
	====================================================

	Stores the genes that the pattern generator uses, allows the genes of offspring and surviving adults to be seperated.



	xv) Setup_Defaults
	====================================================

	Stores the previously used setup settings for 1)_CamoWild_Setup

	

	xvi) Train_Patterns
	====================================================

	The pattern generator for the training target patterns.



---------------------------------------------------------------------------------------------------------------------------------------------------------

3) PRINTER EXPERIMENT INSTUCTIONS 

---------------------------------------------------------------------------------------------------------------------------------------------------------

Listed here are the steps you will need to take to running these scripts for your own printer experiment.



1. Requirements
====================================================

- A colour calibrated printer

- A scale reference for your target's size compared to printed A4 images.


2. Setup Populations

====================================================

- Use the 1)_CamoWild_Setup script to create populations for the number of treatments anre repeats you want to use.

- We recommend trialling a few differrent print sheet layout settings until you can find the most paper saving arrangement.



3. Enter Fitness values

====================================================

- Once you have recorded the fitness rankings enter them for each population using the 2_Population_Fitness_Submission script.

- Repeat until all generations are done.



---------------------------------------------------------------------------------------------------------------------------------------------------------

4) ImageGA RECOMENDATIONS

---------------------------------------------------------------------------------------------------------------------------------------------------------

- DO NOT ENABLE ADAPTIVE MUTATION SYSTEMS, these were designed for continious not ordinal fitness values.

- The proportions for (kill,breed,mutate) should be based on the group sizes. E.g. in a group of 4, 50% killed and 50% bred would be suitable but
  33% bred and 66% killed would not be.

- The number rescued should also be based on group sizes, e.g. if there are 6 groups with 4 per group. The number rescued should be 6.










