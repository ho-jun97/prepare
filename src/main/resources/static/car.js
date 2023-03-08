let table;
$(document).ready(function () {
    table = $("#data_list").DataTable({
        searching: false,
        responsive: true,
        select: true,
        ordering: true,
        paging: true,
        lengthChange: false,
        info: true,
        ajax: {
            data: {
                target: function() { return $("#target").val()}
            },
            url: "/cars",
            type: "GET",
            contentType: "application/json",
            dataSrc: function(data){
                return data;
            }
        },
        columns: [
            {data: "id"},
            {data: "number"},
            {data: "username"},
            {data: "location"}
        ],
        columnDefs: [
            {
                target: 3,
                render: function(data, type, row, meta){
                    return '<a href="/map?id='+row.id+'" id="address">'+data+'</a>';
                }
            },
            {target: 0, width: "100px"},
            {target: 1, width: "200px"},
            {target: 2, width: "100px"},
            {target: 3, width: "400px"},

        ],
    });
    $('#searchBtn').click(function(){
        table.ajax.reload();
    });
});

