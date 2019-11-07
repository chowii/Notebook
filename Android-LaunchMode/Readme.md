https://medium.com/@veeresh.charantimath8/playing-with-android-task-affinity-and-launch-modes-5c36a0421e83

https://itnext.io/the-android-launchmode-animated-cheatsheet-6657e5dd9b0f

# adb command for activity backstack dump
adb shell dumpsys activity activities | sed -En -e ‘/Running activities/,/Run #0/p’
