import os.path

# Programed by DragoScript (https://github.com/DragoScript) #
print("===================================")
print("=     Welcome to PyFileCreate     =")
print("=        By: DragoScript          =")
print("===================================")

print("\nPlease enter the file's name and extension")
fileName = str(input(": "))

extensionCheckFail = "." not in fileName
if (extensionCheckFail == True):
    print("Please enter", fileName+"'s file extension")
    fileExtension = str(input(": ."))
    fileName = fileName+"."+fileExtension

print("\nPlease enter the path where the file will be created")
print("\n[ \ ] for Windows, [ / ]for Linux & MacOS")
filePath = str(input(": "))

print("\n Are on Windows?")
yORn = str(input("(y/N): "))

if (yORn == "y" or yORn == "Y"):
    filePath = filePath+"\\"
else:
    filePath = filePath+"/"

filePathName = filePath+fileName


if (os.path.exists(filePathName) == True):
    print(fileName, "already exist in", filePath +
          "\nDo you want to override it? (y/N)")

    yORn = str(input(": "))
    if (yORn == "y" or yORn == "Y"):
        try:
            file = open(filePathName, "w")
            print(fileName, "in", filePath, "has been overrided.")
            file.close()
        except FileNotFoundError:
            print("The file path is incorret, please try again.")


else:
    try:
        file = open(filePathName, "w")
        print("\nCreated", fileName, "in", filePath)
        file.close()

    except FileNotFoundError:
        print("The file path is incorrect, please try again.")
