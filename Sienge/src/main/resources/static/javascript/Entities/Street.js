class Street{

    constructor(){
        streetPavimentadaDistance = 0;
        streetNotPavimentadaDistance = 0;
        streetTotalCostPavimentada = 0;
        streetTotalCostNaoPavimentada = 0;
    }

    /**
     * Get method to get the cost of paved street
     */
    function getStreetPavimentada () {
        if(costForm.$invalid){return;}
        $http({
            url: "/street/pavimentada",
            method: "GET",
            params: {kilometer: parseInt(streetPavimentadaDistance)}

        }).then(
            function (response) {
                streetTotalCostPavimentada = response.data;
                $watch('streetTotalCostPavimentada', function () {
                    totalCost = 0;
                    totalCost =
                        streetTotalCostPavimentada+
                        streetTotalCostNaoPavimentada+
                        chargeWeigthCost+
                        vehicleCost;
                });
            },
            function (error) {
                console.log(response);
            });
    }


    /**
     * Get method to get the cost of Not paved street
     */
    function getStreetNaoPavimentada () {
        $http({
            url: "/street/nao-pavimentada",
            method: "GET",
            params:{kilometer:parseInt(streetNotPavimentadaDistance)}

        }).then(
            function(response) {
                streetTotalCostNaoPavimentada = response.data;
                $watch('streetTotalCostNaoPavimentada', function () {
                    totalCost = 0;
                    totalCost =
                        streetTotalCostPavimentada+
                        streetTotalCostNaoPavimentada+
                        chargeWeigthCost+
                        vehicleCost;
                });
            },
            function(error) {
                console.log(response);
            });
    }
}