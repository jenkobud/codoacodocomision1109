const TICKET_PRICE = 200;
const CLASS_DISCOUNT = [0.20, 0.50, 0.85, 1];
const calcPayment = () => {
    const ticketInputs = document.querySelectorAll("input");
    /*0 - NOMBRE
      1 - APELLIDO
      2 - CORREO
      3 - CANTIDAD */
    const ticketClass = document.getElementById("class");
    const paymentDetail = document.getElementById("paymentDetail");
    const totalPriceDiv = document.getElementById("totalPrice");

    paymentDetail.innerHTML=`
    <div class="col-8 d-flex justify-content-center">Tickets:</div>
    <div class="col-4 d-flex justify-content-end">${ticketInputs[3].value} * $${TICKET_PRICE} = $${ticketInputs[3].value * TICKET_PRICE}</div>
    <div class="col-8 d-flex justify-content-center">Descuento:</div>
    <div class="col-4 d-flex justify-content-end">-%${parseInt((1-CLASS_DISCOUNT[ticketClass.value])*100)}</div>
    <div class="col-12 border-bottom border-secondary"></div>
    `;
    let price = (TICKET_PRICE * ticketInputs[3].value) * CLASS_DISCOUNT[ticketClass.value];
    totalPriceDiv.innerHTML=`$${price}`;
}

const buyTickets = () => {
    const mainContentDisplayer = document.getElementById("contentDisplayer");
    mainContentDisplayer.innerHTML=`
    <div class="row w-100 justify-content-center align-items-center m-0 my-2">
      <div class="col-md-4 col-sm-6 col-xs-12 discount-container border border-primary text-center m-1">
        <h4 class="font-monospace my-3 pt-3"><b>Estudiante</b></h4>
        <p>Tienen un descuento</p>
        <b class="fs-5 my-1">80%</b>
        <p class="text-secondary"><small>* presentar documentación</small></p>
      </div>
      <div class="col-md-4 col-sm-6 col-xs-12 discount-container border border-info text-center m-1">
        <h4 class="font-monospace my-3 pt-3"><b>Trainee</b></h4>
        <p>Tienen un descuento</p>
        <b class="fs-5 my-1">50%</b>
        <p class="text-secondary"><small>* presentar documentación</small></p>
      </div>
      <div class="col-md-4 col-sm-6 col-xs-12 discount-container border border-warning text-center m-1">
        <h4 class="font-monospace my-3 pt-3"><b>Junior</b></h4>
        <p>Tienen un descuento</p>
        <b class="fs-5 my-1">15%</b>
        <p class="text-secondary"><small>* presentar documentación</small></p>
      </div>
    </div>
    <form class="my-3" action="">
      <div class="container">
        <div class="text-center">
          <span class="font-monospace text-uppercase">venta</span>
          <h1 class="font-monospace"><b>VALOR DE TICKET $200</b></h1>
        </div>
        <div class="row my-3">
          <div class="col-6"><input class="form-control" type="text" name="name" id="name" placeholder="Nombre"></div>
          <div class="col-6"><input class="form-control" type="text" name="lastname" id="lastname" placeholder="Apellido"></div>
        </div>
        <div class="row my-3">
          <div class="col-12"><input class="form-control" type="email" name="email" id="email" placeholder="Correo"></div>
        </div>
        <div class="row my-3">
          <div class="col-6">
            <label class="form-label" for="quantity">Cantidad</label>
            <input class="form-control" type="number" name="quantity" id="quantity" value="0" min="0">
          </div>
          <div class="col-6">
            <label class="form-label" for="class">Categoria</label>
            <select class="form-select" name="class" id="class">
              <option selected value=0>Estudiante</option>
              <option value=1>Trainee</option>
              <option value=2>Junior</option>
              <option value=3>Ninguna</option>
            </select>
          </div>
        </div>

        <div class="row rounded py-2 my-3 mx-0" style="background-color: #cce5ff;">
          <div class="row p-0 m-0" id="paymentDetail"></div>
          <div class="col-8 fs-5">Total a Pagar:</div>
          <div class="col-4 fs-5 text-end" id="totalPrice">$0</div>
        </div>
        <div class="row">
          <div class="col-6"><button type="button" onclick="buyTickets()" class="btn btn-lg btn-send w-100">Borrar</button></div>
          <div class="col-6"><button type="button" class="btn btn-lg btn-send w-100" onclick="calcPayment()">Resumen</button></div>
        </div>
      </div>
    </form>
    `;
}