angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app/api/v1';
    $scope.offsetPage = 0;

    $scope.change_page = function (pageVar, limit) {
        $scope.offsetPage = $scope.offsetPage + pageVar;
        if ($scope.offsetPage < 0) $scope.offsetPage = 0;
        $http({
            url: contextPath + '/products/get_by_page',
            method: 'GET',
            params: {
                pageNumber: $scope.offsetPage,
                pageSize: limit
            }
        }).then(function (response) {
            $scope.ProductList = response.data;
        });
    }

    $scope.deleteProductById = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.change_page($scope.offsetPage, 10);
            });
    }

    $scope.submitCreateNewProduct = function () {
        $http.post(contextPath + '/products/new', $scope.newProduct)
            .then(function (response) {
                $scope.change_page($scope.offsetPage, 10);
            });
    }
    $scope.addProductToCart = function (product) {
        $http.post(contextPath + '/carts', product)
            .then(function (response) {
                $scope.getProductsFromCart();
            });
    }
    $scope.deleteProductFromCart = function (cart_id) {
        $http.delete(contextPath + '/carts/' + cart_id)
            .then(function (response) {
                $scope.getProductsFromCart();
            });
    }
    $scope.getProductsFromCart = function () {
        $http.get(contextPath + '/carts')
            .then(function (response) {
                $scope.ProductsFromCart=response.data;
            });
    }

    $scope.change_page($scope.offsetPage, 10);
});