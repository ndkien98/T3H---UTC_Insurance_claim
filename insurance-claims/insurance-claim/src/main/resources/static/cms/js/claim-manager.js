$(document).ready(function() {
    const PAGE_SIZE = 3;
    // Initial load
    fetchClaims();

    function fetchClaims(page = 0) {
        const claimCode = $('#search-ma-yeu-cau').val();
        const fromDate = $('#from-date').val();
        const toDate = $('#to-date').val();
        const statusCode = $('#trang-thai-yeu-cau').val();

        const requestData = {
            claimCode,
            fromDate,
            toDate,
            statusCode
        };

        $.ajax({
            url: `http://localhost:8080/api/claims?page=${page}&size=`+PAGE_SIZE,
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(requestData),
            success: function(response) {
                renderTable(response);
                renderPagination(response.pageNumber, response.totalPages);
            },
            error: function(error) {
                console.error('Error fetching claims:', error);
            }
        });
    }

    function renderTable(data) {
        const tbody = $('#claims-table tbody');
        tbody.empty();
        data.content.forEach(item => {
            const row = `<tr>
        <td><input type="checkbox" class="recordCheckbox"></td>
        <td><a href="detail-claim.html" style="text-decoration: none;"><strong>${item.claimCode}</strong></a></td>
        <td>${item.customerName}</td>
        <td>${item.insuranceProductName}</td>
        <td>${item.claimDate}</td>
        <td>${item.description}</td>
        <td><span class="badge bg-label-primary me-1">${item.statusDescription}</span></td>
      </tr>`;
            tbody.append(row);
        });
    }

    function renderPagination(pageNumber, totalPages) {
        const pagination = $('#pagination');
        pagination.empty();
        if (pageNumber > 0) {
            pagination.append(`<li class="page-item"><a class="page-link" href="#" data-page="${pageNumber - 1}">&laquo;</a></li>`);
        }
        for (let i = 0; i < totalPages; i++) {
            pagination.append(`<li class="page-item ${i === pageNumber ? 'active' : ''}"><a class="page-link" href="#" data-page="${i}">${i + 1}</a></li>`);
        }
        if (pageNumber < totalPages - 1) {
            pagination.append(`<li class="page-item"><a class="page-link" href="#" data-page="${pageNumber + 1}">&raquo;</a></li>`);
        }
    }

    $('#search-button').click(function() {
        fetchClaims();
    });

    $(document).on('click', '#pagination .page-link', function(e) {
        e.preventDefault();
        const page = $(this).data('page');
        fetchClaims(page);
    });

});