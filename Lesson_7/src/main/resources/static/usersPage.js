angular.module('app', []).controller('userController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app/api/v1';

    $scope.getUsers = function () {
        $http.get(contextPath + '/users')
            .then(function (response) {
            $scope.userList = response.data;
        });
    }

    $scope.deleteUserById = function (userId) {
        $http.delete(contextPath + '/users/' + userId)
            .then(function (response) {
                $scope.getUsers();
            });
    }

    $scope.toEditUser = function (user) {
        $scope.editUser=user;

    }


    $scope.submitCreateNewUser = function () {
        $http.post(contextPath + '/users', $scope.newUser)
            .then(function (response) {
                $scope.getUsers();
            });
    }

    $scope.submitEditUser = function () {
        $http.put(contextPath + '/users', $scope.editUser)
            .then(function (response) {
                $scope.getUsers();
            });
    }

    $scope.getUsers();
});