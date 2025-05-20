# 2D-FirstPerson
A 2D game in first person, which would be 1D

 This "game" was an idea I had while thinking about life in other dimensions, and tried to make a representation in java 
 I made this project start to finish in 3 days, excepting the game loop which I had from other projects

## Use
You gotta execute the static main of class Ventana

- WASD to move relative of orientation.
- Q & E to rotate the player.
- Mouse wheel to change the zoom.
- Mouse drag to move the camera in the bidimencional plane.

 You can press in the first person view (bottom of window) to change how the mouse behaves.
 
 Doing so will make the horizontal movement of the mouse be transform'd into rotation of the player, just like a first person game (note: I haven't put the effort to lock the mouse when this is on, this is just a test, not a full game)

 Then you can press outside of the first person view to return to the normal control.

## Features & Details
 The engine supports 2D rendering of any amount of shape and individual velocity and acceleration.
 It does not have any type of collision nor physics, but I have plans for that.

 In this program, there are objects called 'Obstaculo' which would be just an entity.
 
The entities have, among other things, an ArrayList of 'Vector2' called 'vertices' which would be the vertices of the shape of the entity and an ArrayList of int [] (each one would be int[2]) referring to which vertices are connected to which others

 Entities are stored in an Array in the 'Juego' class.

  The class Juego has the propose of handling the updates and player movement.
 Inside the constructor is where the map can be initialized, in here you can type escena.add(/*new Obstaculo*/); clearly for adding new entities to the scene.
 There is a class called ObstFactory which exists so we don't have to hardcode each vertex we create.
 
 .
 
 Those are the only key things you gotta know if you want to use this program, it was fun.

<img src="https://github.com/GasparLiboreiro/2D-FirstPerson/blob/master/imgs/2DFP%20(1).jpg" alt="drawing" width="30%"/><br>
<img src="https://github.com/GasparLiboreiro/2D-FirstPerson/blob/master/imgs/2DFP%20(2).PNG" alt="drawing" width="30%"/><br><br><br><br><br><br>
<img src="https://github.com/GasparLiboreiro/2D-FirstPerson/blob/master/imgs/2DFP%20(4).PNG" alt="drawing" width="30%"/>   <img src="https://github.com/GasparLiboreiro/2D-FirstPerson/blob/master/imgs/2DFP%20(5).PNG" alt="drawing" width="30%"/>  <img src="https://github.com/GasparLiboreiro/2D-FirstPerson/blob/master/imgs/2DFP%20(6).PNG" alt="drawing" width="30%"/>
