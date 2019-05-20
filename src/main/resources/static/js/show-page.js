"use strict";

$(document).ready(function () {


    mapboxgl.accessToken = publicMapBoxKey;

    var map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/mapbox/streets-v9',
        zoom: 13
        // center: [-98.4916, 29.4252]

    });

    function geocode(search, token) {
        var baseUrl = 'https://api.mapbox.com';
        var endPoint = '/geocoding/v5/mapbox.places/';
        return fetch(baseUrl + endPoint + encodeURIComponent(search) + '.json' + "?" + 'access_token=' + token)
            .then(function(res) {
                return res.json();
                // to get all the data from the request, comment out the following three lines...
            }).then(function(data) {
                return data.features[0].center;
            });
    }


    //Sets center of map at SA,TX
    var location = $('#location').html();
    var completeLocation = location + ", San Antonio";
    console.log(location);

    geocode(completeLocation, mapBoxKey).then(function (data) {
        map.setCenter(data);

        var marker = new mapboxgl.Marker({
            draggable: true
        })
            .setLngLat(data)
            .addTo(map);
        console.log(data);

    })




})