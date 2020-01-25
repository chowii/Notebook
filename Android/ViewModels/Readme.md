Playing with ViewModels from Android Architecture Components


## Internals of Android Architecture Components Part I — The ViewModel 
https://medium.com/the-lair/internals-of-android-architecture-components-part-i-the-viewmodel-d893e362a0d9

## When to load data in ViewModels
https://proandroiddev.com/when-to-load-data-in-viewmodels-ad9616940da7d

## Android MVVM — Do’s and Don’ts
https://android.jlelse.eu/mvvm-dos-and-don-ts-5950d6f347d4


### How to's
Activity-Fragment communication
https://medium.com/mindorks/how-to-communicate-between-fragments-and-activity-using-viewmodel-ca733233a51c

ParentFragment-ChildFragment communication
https://stackoverflow.com/a/23079798

ViewModel Dependency Injections 

---

• (v) If the ViewModel needs the Application context it should extend AndroidViewModel and receive the Application on the constructor

• (v) ViewModelProvider preserves ViewModel instance, but not ViewModelFactory instance
https://proandroiddev.com/5-common-mistakes-when-using-architecture-components-403e9899f4cb

• (v) A ViewModel class shouldn’t have any reference to LifecycleOwner, like Activity or fragment, or to the context, this makes the unit testing easier

• (v) ViewModel object can contain LifecycleObservers, such as LiveData objects, but a ViewModel must never observe changes to lifecycle-aware observables, this has to be done on the LifecycleOwner

• (v) Passing references to ViewModels to other classes

_An example of leaking ViewModels can be passing a ViewModel reference to a listener to a Repository. Ensure to remove listener in `onCleared()` or use `WearReference`._
_Ideally use **LiveData** to communicate between other objects, in this case the Repository._