import os.path

# Programmed by DragoScript (https://github.com/DragoScript) #
print("===================================")
print("=     Welcome to PyFileRead       =")
print("=        By: DragoScript          =")
print("===================================")

print("\nEnter the name of a file text that you want to read")
fileName = str(input(": "))

extensionCheckFail = "." not in fileName
if (extensionCheckFail == True):
    fileName = fileName+".txt"

print("\nPlease enter the path where you're text file is located")
print("\n[ \ ] for Windows, [ / ]for Linux & MacOS")
filePath = str(input(": "))

print("\n Are on Windows?")
yORn = str(input("(y/N): "))

if (yORn == "y" or yORn == "Y"):
    filePath = filePath+"\\"
else:
    filePath = filePath+"/"

filePathName = filePath+fileName

try:
    file = open(filePathName, "r")
    print("")
    print(file.read())
    file.close()

except FileNotFoundError:
    print("The file path is incorrect, please try again.")
