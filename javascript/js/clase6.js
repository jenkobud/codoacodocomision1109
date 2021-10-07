
class Mascota {
    constructor(nombre, propietario, especie, raza="mestiza", edad, peso, profilePic="none"){
        this.nombre = nombre;
        this.propietario = propietario;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.profilePic = profilePic;
    }
    mostarPropietario(){ return this.propietario; }
}

class propietario{
    constructor(nombre, apellido, adeuda=0){
        this.nombre = nombre;
        this.apellido = apellido;
        this.adeuda = this.adeuda;
        this.mascotas = [];
    }
    agregarMascota(mascota){ this.mascotas.push(mascota); }
}