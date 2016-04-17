angular.module('starter.services', [])
.factory('RawData', function() {
    // Might use a resource here that returns a JSON array

    // Some fake testing data
    var rawData = [{
      "id": "1",
      "tipo": "evento",
      "titulo": "Esta es una noticia de dos líneas principal",
      "bg": "fondo-not.png",
      "bgdetail": "noti-detalle.png",
      "fec": "ABRIL, 14,  2:56 AM",
      "com": "Backpack from Très Bien. Made in collaboration with Haerfest. Nylon body with top zip closure. Leather bottom. Outer compartment with zip closure and leather trims. Adjustable shoulder straps in leather. Metal hardware. Lined with cotton. Inner compartments. Outer logo branding."
    }];

    return {
        all: function() {
            return rawData;
        },
        get: function(id) {
            for (var i = 0; i < rawData.length; i++) {

                if (parseInt(rawData[i].id) === parseInt(id)) {
                    return rawData[i];
                }
            }
            return null;
        }
    };
})

.factory('ServicioData', function() {
    // Might use a resource here that returns a JSON array

    // Some fake testing data
    var servData = [{
      "id": "1",
      "logo": "logo1.png",
      "titulo": "Restaurante",
      "com": "Nuestro Menú"
    }];

    return {
        all: function() {
            return servData;
        },
        get: function(id) {
            for (var i = 0; i < servData.length; i++) {

                if (parseInt(servData[i].id) === parseInt(id)) {
                    return servData[i];
                }
            }
            return null;
        }
    };
});
