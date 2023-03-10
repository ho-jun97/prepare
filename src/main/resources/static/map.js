var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
    level : 13 // 지도의 확대 레벨
});

// 마커 클러스터러를 생성합니다
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
    minLevel: 10 // 클러스터 할 최소 지도 레벨
});

// 데이터를 가져오기 위해 jQuery를 사용합니다
// 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
$.ajax({
    url: "/findAllLocation",
    contentType: "application/json",
}).done(function(data){
    var markers = $(data.positions).map(function(i, position) {
        return new kakao.maps.Marker({
            position : new kakao.maps.LatLng(position.lat, position.lng),

        });
    });

    // 클러스터러에 마커들을 추가합니다
    clusterer.addMarkers(markers);
});

function panTo(lat, lng) {
    // 움직일 위치
    var moveLatLon = new kakao.maps.LatLng(lat, lng)

//     var imageSrc = 'marker01.png';                              // 마커이미지 주소
//     imageSize = new kakao.maps.Size(34, 36);                // 마커이미지의 크기
//     imageOption = {offset: new kakao.maps.Point(17, 36)};   // 마커의 좌표와 일치시킬 이미지 안에서의 좌표설정
//
// // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
//     var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);
//
//     var marker = new kakao.maps.Marker({
//         position: moveLatLon,
//         image: markerImage // 마커이미지 설정
//     });

    // 지도 레벨 설정
    map.setLevel(2);
    map.panTo(moveLatLon);
    // marker.setMap(map)
}


