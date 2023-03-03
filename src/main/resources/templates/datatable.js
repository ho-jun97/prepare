// $("#data_list").DataTable({
//     select: true,
//     ordering: false,
//     paging: false,
//     ajax: {url: "data.json", dataSrc: ''},
//     columns: [
//         {data: "id"},
//         {data: "number"},
//         {data: "owner"},
//         {data: "location"}
//     ]
// });
$(document).ready(function () {
    $('#data_list').DataTable();
    $('.dataTables_length').addClass('bs-select');
});