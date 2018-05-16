var naiveButton = $('#naive'),
    closeButton = $('#closeModal'),
    myModal = $('#myModal'),
    modalBody = $('#modalBody');

var clicks = Rx.Observable.fromEvent(naiveButton, 'click');
var close = Rx.Observable.fromEvent(closeButton,'click');

close.subscribe(() =>
{
    myModal.hide();
})


clicks.map(c => {
    return naiveButton.val();
}).switchMap(c => {
    return getPrimesByMethod(c);
}).catch(error => {
    return Rx.Observable.of({ error: true, status: error.status });
}
).map(entity => {

    if (entity.error) {
        return prepareErrorMessage(entity.status);
    }
    return prepareEntity(entity);

}).subscribe(entity => {
    modalBody.empty();
    myModal.show();
    modalBody.append(entity);
}
);

function getPrimesByMethod(method) {

    return $.ajax({
        url: '/backend/primes/'+method,
        dataType: 'json',

    }).promise();
};

function prepareEntity(entity) {

    var container = document.createElement('div'),
        div = document.createElement('div');
    div.classList.add("alert");
    div.classList.add("alert-success");
    div.innerHTML = "Id zapytania - " + '<strong>' + entity.id + '</strong>';
    var numbers = prepareNumbers(entity.data);
    container.append(div);
    container.append(numbers);

    return container;
};

function prepareNumbers(data) {
    var div = document.createElement('div');
    div.classList.add('btn-toolbar');

    for (i of data) {

        var p = document.createElement('p');
        p.classList.add('btn');
        p.classList.add('btn-success');
        p.classList.add('btn-sm');
        p.innerHTML=i;
        div.append(p);
    }
    return div;

}
function prepareErrorMessage(error) {


    var div = document.createElement('div');
    div.classList.add("alert");
    div.classList.add("alert-danger");
    div.innerHTML = "Bład serwera - " + error;

    return div;

};


