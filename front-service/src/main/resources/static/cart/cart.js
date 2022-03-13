angular.module('market-front').controller('cartController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:5555/cart/';

    $scope.loadCart = function () {
        $http({
            url: contextPath + 'api/v1/cart/' + $localStorage.springWebGuestCartId,
            method: 'GET'
        }).then(function (response) {
            $scope.cart = response.data;
        });
    };

    $scope.disabledCheckOut = function () {
        alert("Для оформления заказа необходимо войти в учетную запись");
    }

    $scope.clearCart = function () {
        $http.get(contextPath + 'api/v1/cart/' + $localStorage.springWebGuestCartId + '/clear')
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.checkOut = function () {
        $http({
            url: 'http://localhost:5555/core/api/v1/orders',
            method: 'POST',
            data: $scope.orderDetails
        }).then(function (response) {
            $scope.loadCart();
            $scope.orderDetails = null
        });
    };

    $scope.loadDictionaries = function () {
            $http({
                url: 'http://localhost:5555/core/api/v1/dict/countries',
                method: 'GET'
            }).then(function (response) {
                $scope.countries = response.data;
            });
        };

    $scope.isCountrySet = function() {
        return $scope.orderDetails ? $scope.orderDetails.country : null;
    }

    $scope.isCitySet = function() {
            return $scope.orderDetails ? $scope.orderDetails.city : null;
        }

    $scope.getCities  = function() {
        if($scope.isCountrySet()){
            $http({
                url: 'http://localhost:5555/core/api/v1/dict/countries/'+$scope.orderDetails.country.id+'/cities',
                method: 'GET'
            }).then(function (response) {
                $scope.cities = response.data;
            });
        } else {
         $scope.cities = null;
        }

    }

    $scope.loadCart();
    $scope.loadDictionaries();

});