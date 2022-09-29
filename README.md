# 2D-FirstPerson
a 2D game with first person, which would be 1D

 This "game" was an idea I had while thingink about life in other dimencions, and tryed to make a representation in java 
 I made this proyect start to finish in 3 days, excepting the gameloop which I had from other proyects

## Use
- WASD to move relative of orientation.
- Q & E to rotate the player.
- Mouse wheel to change zoom.
- Mouse drag to move the camera in the bidimencional plane.

 You can press in the first person view (bottom of window) to change how the mouse behaves.
 
 Doing so will make the horizontal movement of the mouse be transform'd into rotation of the player, just like a first person game (note: I haven't put the efford to lock the mouse when this is on, this is just a test, not a full game)

 Then you can press outside of the first peron view to return to the normal control.


## Features & Details
 The engine supports 2D rendering of any amount of shape and individual velocity and acceleration.
 It does not have any type of collition nor phisics, but I have plans for that.

 In this program there are objects called 'Obstaculo' which would be just an entity.

 The entitys have, among other things, an ArrayList of 'Vector2' called 'vertices' which would be the vertices of the shape of the entity and an ArrayList of int[] (each one would be int[2]) refering to which vertecies are conected to which others

 Entitys are stored in an Array in the 'Juego' class.

 The class Juego ondy has the Array called 'escena', would be the array with all the entitys, and an object of type 'Jugador'.
 The class Juego has the propose of handeling the updates and player movement.
 Inside the constructor is where the map can be initialized, in here you can type escena.add(/*new Obstaculo*/); cclearly for adding new Entitys to the scene.
 There is a class called ObstFactory which exists so we don't have to hardcode each vertex we create.
 
 .
 
 Those are the only key things you gotta know if you want to use this program, it was fun.
