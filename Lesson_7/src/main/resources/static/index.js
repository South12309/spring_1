angular.module('app',[]).controller('indexController', function($scope, $http){
    const contextPath = 'http://localhost:8080/app/products';
    $scope.offsetPage = 0;

    $scope.change_page = function(pageVar, limit) {
        $scope.offsetPage = $scope.offsetPage + pageVar;
        if ($scope.offsetPage<0) $scope.offsetPage=0;
        $http({
            url: contextPath +'/get_by_page',
            method: 'GET',
            params: {
                pageNumber: $scope.offsetPage,
                pageSize: limit
            }
        }).then(function(response) {
            $scope.ProductList = response.data;
        });
    }

    $scope.deleteProductById = function(productId){
        $http.get(contextPath + '/delete/'+productId)
            .then(function(response) {
                $scope.change_page(0, 10);
            });
    }

    $scope.submitCreateNewProduct = function(){
        $http.post(contextPath + '/new', $scope.newProduct)
            .then(function(response) {
                $scope.change_page(0, 10);
            });
    }

    $scope.change_page(0, 10);
});