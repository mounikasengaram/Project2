Run("notepad.exe");
WinWaitActive("Untitled-Notepad");
Send("mounika");
WinClose("Untitled-Notepad");
WinWaitActive("Notepad","Save");
Sleep(3000);
Send("!n")
