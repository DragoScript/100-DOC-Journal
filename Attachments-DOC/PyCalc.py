print("Hello There! Welcome to PyCalc")
print("")
print("=========================")
print("# - Select your Mode -  #")
print("#  ___________________  #")
print("# |                   | #")
print("# | 1. Addition       | #")
print("# | 2. Subtraction    | #")
print("# | 3. Multiplication | #")
print("# | 4. Division       | #")
print("# |___________________| #")
print("=========================")
print("")
userInput = int(input(": "))

errorCheck = False
while (errorCheck != True):
    if (userInput == 1):
        print("\n### Addition ###")
        print("Please enter 2 numbers")
        num1 = float(input("num1: "))
        num2 = float(input("num2: "))
        total = num1 + num2
        print("Result: ", total)
        break

    elif (userInput == 2):
        print("\n### Subtraction ###")
        print("Please enter 2 numbers")
        num1 = float(input("num1: "))
        num2 = float(input("num2: "))
        total = num1 - num2
        print("Result: ", total)
        break

    elif (userInput == 3):
        print("\n### Multiplication ###")
        print("Please enter 2 numbers")
        num1 = float(input("num1: "))
        num2 = float(input("num2: "))
        total = num1 * num2
        print("Result: ", total)
        break

    elif (userInput == 4):
        print("\n### Division ###")
        print("Please enter 2 numbers")
        num1 = float(input("num1: "))
        num2 = float(input("num2: "))
        total = num1 / num2
        print("Result: ", total)
        break

    else:
        print("Error, please enter a valid mode")
        userInput = int(input(": "))
        errorCheck = True
