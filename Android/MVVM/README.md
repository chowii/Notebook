## What is MVVM
MVVM stands for Model View ViewModel and it is an architectural pattern for implementing user interfaces.

In MVVM, the ViewModel does not need a reference of the View to update the View; ViewModel listens to events from the 
View, then publishes relevant changes which the view observes.

MVVM consists of three parts:
- Model/Data: it is the data source, that is abstracted away. Model/Data represents the business (models)objects that 
encapsulate the data and behavior of the application. 
- ViewModel: exposes streams of data that is relevant and specific to the View/UI component.
- View: UI that users see and interacts with, to send and receive the data from the view model.

## Why MVVM over MVP
- Tight Coupling<br>
    - Presenter and the view has a 1:1 relationship, presenter holds the reference of the view, view holds the 
    reference of the presenter.
- Testability
    - No dependency of the View, or mocking methods of its partner  