####################################################
##Restriction site scanning script                ##
##By: Richard Jansen, HAN University 2014         ##
##Created: 14-11-2014, last revision: 21-11-2014  ##
####################################################

DdeI   = "CTGAG"    #cuts at C^TGAG	Desulfovibrio desulfuricans    	
BspMII = "TCCGGA"   #cuts at T^CCGGA	Klebsiella pneumoniae 
EcoRI  = "GAATTC"   #cuts at G^AATTC	Escherichia coli
HindIII= "AAGCTT"   #cuts at A^AGCTT	Haemophilus influenzae
TaqI   = "TCGA"     #cuts at T^CGA	Thermus aquaticus

def getSequentie (bestandsnaam):						#segment that reads the file, starting only at the sequence
    bestand = open (bestandsnaam,encoding="latin1")				#courtesy of: Martijn van der Bruggen, HAN University, 2008
    startReading = False            
    raw_data = ""   
    for regel in bestand:
        if startReading:
            raw_data += regel[10:]
        if "ORIGIN" in regel:
            startReading = True
    sequence= raw_data.replace(' ','').replace('\n','').replace('\r','')
    return sequence

sequentie = getSequentie("afvink2.txt")						#refers to the sequence as: "sequence"

print ("Available restriction enzymes: DdeI, BspMII, EcoRI, HindIII and TaqI")	#displays a string to inform the user about the available options

										#restriction enzymes and their restriction sites
DdeI    = "ctgag"								#DdeI
BspmII	= "tccgga"								#BspmII
EcoRI	= "gaattc"								#EcoRI
HindIII	= "aagctt"								#HindIII
TaqI	= "tcga"								#TaqI


x = str(input("Which restriction enzyme would you like to check? "))		#"X" = input given by the user (restriction enzymes)

										#for every input possibillity the matching restriction site is given
if x == "DdeI":
	if "ctgag" in sequentie:
		print ("DdeI in there dawg")

if x == "BspMII":
	if "tccgga" in sequentie:
		print ("BspMII in there dawg")
	
if x == "EcoRI":
	if "gaattc" in sequentie:
		print ("EcoRI in there dawg")
	
if x == "HindIII":
	if "aagctt" in sequentie:
		print ("HindIII in there dawg")

if x == "TaqI":
	if "tcga" in sequentie:
		print ("TaqI in there dawg")

print ("C0ngr4tul4t10ns, y0u 4r3 n0w 4 1337 H4XXP3RT")