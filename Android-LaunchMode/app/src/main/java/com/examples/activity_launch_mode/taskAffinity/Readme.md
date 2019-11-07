# Activity Task affinity
• The affinity of a task is determined by the affinity of its root activity
• By default, all activities within an application share the same affinity
• The name of that affinity is the same as the package name set by the <manifest> element

Overriding `taskAffinity` attribute in the manifest, either for a specific activity or on
the application element, groups activities together.

Useful when closing a subset of the activities immediately below in the current task

# FinishAffinity
• Finishes the current activity, as well as all activities, in the current task with the
    same immediately below it same affinity.
