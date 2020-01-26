# Playing with LiveData from Android Architecture Components


## What is LiveData?


LiveData follows the Observer pattern, notifying subscribers of new data being available.<br>
LiveData is Lifecycle aware, which means that it will notify subscribers only when it’s in an active lifecycle state 
(_**STARTED**_ between _**onPause**_ and _**onStop**_), and it will dispose the subscription when the
Lifecycle terminates and is destroyed.


### Internals of Android Architecture Components Part II— LiveData
https://medium.com/the-lair/internals-of-android-architecture-components-part-ii-livedata-a26a4d11795
<br>
##### How observing LiveData works
- To observe data emissions from LiveData; it (LiveData) depends on a LifecycleOwner and the Observer instance we create.<br>
- When the lifecycle is not in the DESTROYED state, observe creates a LifecycleBoundObserver
instance using the LifecycleOwner and the Observer.<br>
- LiveData ensures two of the same Observer with different LifecycleOwners weren't added,
it sets the wrapper to listen for Lifecycle events

##### How LiveData emissions/notifies observers
- 2 Ways to emit changes.

    + `setValue`<br>
    Sets the value, and if there are active observers, notifies observers. Asserts that the calls are on main thread
    + `postValue` <br>
    Posts a task to a main thread to set the given value

LiveData will invalidate a previous dispatch if needed, and iterate and notify the observers when:

- The lifecycle is active

- The version dispatched is newer than the last version received


##### How is LiveData Lifecycle aware?

When observing LiveData (`LiveData#observe` method), a LifecycleBoundObserver is created by wrapping the provided 
observer and the LifecycleOwner. When Activity or Fragment is destroyed the observers subscription will be disposed. 
LifecycleBoundObserver actively checks the Lifecycle state of the owner in the method `LifecycleBoundObserver#shouldBeActive()`
and `onStateChanged()` will remove this from the observer list when the DESTROYED state is reached. This allows to
create the observer in onCreate without having to worry about unsubscribing or disposing of it in any other way in onDestroy
  
##### How LiveData delays notifications on non-active Lifecycle state?
On LifecycleBoundObserver, onStateChanged calls activeStateChanged (implemented in ObservableWrapper), to re-submit
the latest value when it becomes active again

----

### ViewModels and LiveData: Patterns + AntiPatterns
https://medium.com/androiddevelopers/viewmodels-and-livedata-patterns-antipatterns-21efaef74a54

• (x) Don’t let ViewModels (and Presenters) know about Android framework classes

• (x) Avoid references to Views in ViewModels

• (x) Don’t put logic in the ViewModel that is critical to saving clean state or related to data. Any call you make from a ViewModel can be the last one

• (x) You don’t usually extend LiveData. Let your activity or fragment tell the ViewModel when it’s time to start loading data.

---

• (v) Instead of pushing data to the UI, let the UI observe changes to it.

• (v) Distribute responsibilities, add a domain layer if needed

• (v) Add a data repository as the single-point entry to your data

• (v) Expose information about the state of your data using a wrapper or another LiveData
https://developer.android.com/jetpack/docs/guide#addendum

• (v) Consider edge cases, leaks and how long-running operations can affect the instances in your architecture

• (v) Whenever you think you need a Lifecycle object inside a ViewModel, a Transformation is probably the solution

```kotlin
val repo: LiveData<Repo> = Transformations.switchMap({repoIdLiveData, repoId ->
         if (repoId.isEmpty()) {
             return AbsentLiveData.create()
         }
         return repository.loadRepo(repoId)
     }
 )
```

• In fragments use `viewLifecycleOwner/getViewLifecycleOwner()` instead of fragment instance (`this`)

• Exposing LiveData as immutables to views

• 

