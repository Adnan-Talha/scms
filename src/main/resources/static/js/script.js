
// Chart.js - Applications Over Time
const ctx1 = document.getElementById('applicationsChart');
if (ctx1) {
    new Chart(ctx1, {
        type: 'line',
        data: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'],
            datasets: [{
                label: 'Applications',
                data: [80, 120, 250, 300, 450, 550],
                fill: true,
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                tension: 0.4
            }]
        },
        options: {
            responsive: true
        }
    });
}

