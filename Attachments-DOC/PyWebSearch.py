import webbrowser

# Programmed by DragoScript (https://github.com/DragoScript) #
print("===================================")
print("=     Welcome to PyWebSearch      =")
print("=        By: DragoScript          =")
print("===================================")

print("\nWhat website do you want to open? (eg. duckduckgo.com)")
webDomain = str(input(": "))


extensionCheckFail = "." not in webDomain
while (extensionCheckFail == True):
    if (extensionCheckFail == True):
        print("Please add a . at the end of the website name (eg. .com, .net., .org, .ca, .jp, .gg, .gov, etc.)")
        webExtension = str((input(": ")))
        webDomain = webDomain+webExtension
        extensionCheckFail = "." not in webDomain

webAddress = "https://www."+webDomain

print("\n Are on Windows?")
yORn = str(input("(y/N): "))
if (yORn == "y" or yORn == "Y"):
    print("\nOpening", webAddress, "via the default browser...")
    webbrowser.get('windows-default').open(webAddress)

else:
    print("\nEnter your browser name (eg. firefox, chrome)")
    browser = str((input(": ")))
    print("\nOpening", webAddress, "via", browser, "...")
    webbrowser.get(browser).open(webAddress)
