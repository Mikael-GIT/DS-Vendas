import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/request';
type ChartData = {
    labels: string[];
    series: number[];
}
function DonutChart() {
    //Utilizando o Hook useState
    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

    //Definindo o Hook useEffect que basicamente executa algo na instancianção ou destruição do componente, observa estado
    useEffect(() => {
        //Fazendo requisição pra trazer os dados da API
        axios.get(`${BASE_URL}/sales/amount-by-seller`)
            //O .then é um promise que definimos dentro dele uma função que deve ser executada quando a resposta chegar e chegar com sucesso da requisição
            .then((response) => {
                console.log(response.data);
                const data = response.data as SaleSum[]; //Fazendo Cast do response.data, retorno da API para um objeto do tipo SaleSum
                const myLabels = data.map(x => x.sellerName);
                const mySeries = data.map(x => x.sum);
                setChartData({ labels: myLabels, series: mySeries });
            });
    }, []);

    //Forma ERRADA


    //const mockData = {
    //    series: [477138, 499928, 444867, 220426, 473088],
    //    labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    //}

    const options = {
        legend: {
            show: true
        }
    }
    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;