
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
    editarPeso(nuevoPeso) { this.peso = nuevoPeso; }
    getFoto() { return this.profilePic; }
    getNombre() { return this.nombre; }
    getEdad() { return this.edad;}
    getPeso() { return this.peso;}
}

class Propietario{
    constructor(nombre, apellido, adeuda=0){
        this.nombre = nombre;
        this.apellido = apellido;
        this.adeuda = this.adeuda;
        this.mascotas = [];
    }
    agregarMascota(mascota){ this.mascotas.push(mascota); }
}



//--------------------------------- Logic -------------------------------------------
const log = console.log;
const addNewPet=() => {
    // 0: input#petName.form-control
    // 1: input#petSpecie.form-control
    // 2: input#petBreed.form-control
    // 3: input#petAge.form-control
    // 4: input#petWeight.form-control
    // 5: input#petProfilePic.form-control
    // 6: input#ownerName.form-control
    // 7: input#ownerLastName.form-control
    // 8: input#ownerMail.form-control
    // 9: input#ownerDebt.form-control
    const data = document.querySelectorAll("input");
    //console.log(data[2].value);
    let mascota = new Mascota(data[0].value, (data[6].value +" "+ data[7].value), data[1].value, data[2].value, data[3].value, data[4].value, data[5].value);
    let propietario = new Propietario(data[6].value, data[7].value, data[9].value);
    propietario.agregarMascota(mascota);
    
    let petShower = document.getElementById("petShower");
    if(petShower === null){
        let container = document.getElementById("idClase6");
        container.innerHTML=`
        <div class="container border rounded">
            <h3>Mascotas:</h3>
            <div class="container-fluid d-flex flex-column" id="petShower"></div>
        </div>`;
        petShower = document.getElementById("petShower");
    }
    petShower.innerHTML+=`
    <div>
        <div class="card mb-3 bg-dark text-white">
        <div class="row g-0">
            <div class="col-md-2"><img
                src="${mascota.getFoto()}"
                class="img-fluid rounded-start" alt="petProfilePic" ></div>
            <div class="col-md-10">
                <div class="card-body">
                <a class="text-decoration-none text-white" href=""><b>
                    <h5 class="card-title">${mascota.getNombre()}</h5>
                </b></a>
                <p class="card-text">Canino - Mestizo <br> ${mascota.getEdad()} - ${mascota.getPeso()}</p>
                <a class="text-decoration-none text-secondary" href="">${mascota.mostarPropietario()}</a>
            </div>
        </div>
        </div>
    </div>`;
}
