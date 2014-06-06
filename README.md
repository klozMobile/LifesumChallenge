Lifesum Code Challenge
================

This project does search of food with a given API and shows a list of items that contains the given search parameter. User can click on any item of the list to see a detailed information about the item. In the detail screen user has the opportunity of save this information to see it later.

The https connection was handled using Android-Query (AQuery), is a light-weight library for doing asynchronous tasks and manipulating UI elements in Android this saves a lot of work since only needs an url and a given callback to make the server queries.

Once having a json response from the server was easy to make the class modeling using jsonschema2pojo, and using Gson for parsing json to object.

Finally in order to persist user’s selected data, using Sugar ORM was the easiest way to do it since model classes was already made.

The project needs Android support v7 library to compile, is not included in this repository but can be grabbed from android SDK.

A custom action in action bar could be added in order to select multiple item and add them to te saved-list.
Also this could be archived dragging items to an icon in action bar. 

TODOS:
1.- This project doesn’t use loaders for querying user’s data.
2.- There is no way of removing elements from user’s saved-list.
3.- An indicator in detail screen for letting know the user this item is already in his saved-list.


Refrences:
Android-Query (AQuery) 	https://code.google.com/p/android-query/
jsonschema2pojo 	http://www.jsonschema2pojo.org/
Gson			https://code.google.com/p/google-gson/
Sugar ORM		http://satyan.github.io/sugar/index.html