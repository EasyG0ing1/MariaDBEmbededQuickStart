This is a simple Quick Start app for the embedded <a href="https://github.com/vorburger/MariaDB4j">MariaDB Java library.</a>

If you run it as is, it will create a new MariaDB instance using your home folder from which it will create the folder **EmbeddedMariaDB** and a sub folder called **MySchema** which will contain all of the relevant files for that schema.

It listens on port 3307 which you can actually use as an ad hoc MySQL database server if you need that. OR you can copy this code to your own app and modify the variables as needed and have a connection to the embedded database via the Main.CONN Connection object.

It has already taken into account, the often frustrating TimeZone error that happens with first time users, so this is basically 'plug and play' code for getting up and running quickly with embedded MariaDB.

Enjoy! 