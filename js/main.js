(() => {

    angular.module('myApp', ['ngRoute', 'ngResource'])
        .constant('booksUrl', 'http://localhost:8080/Library/webapi/books/')
        // .config(function ($httpProvider){ $httpProvider.defaults.withCredentials=true; })
        .controller('controllerFunction', controllerFunction);


    function controllerFunction($scope, $resource, booksUrl) {
        ////
        $scope.productsResource = $resource(booksUrl + ':id', { id: '@id' });
        $scope.listProducts = function () { $scope.products = $scope.productsResource.query(); }
        $scope.deleteProduct = function (product) {
            product.$delete().then(function () {
                $scope.products.splice($scope.products.indexOf(product), 1);
            });
        }
        $scope.createProduct = function (product) {
            new $scope.productsResource(product).$save().then(function (newProduct) {
                $scope.products.push(newProduct);
                $scope.editedProduct = null;
            });
        }
        $scope.updateProduct = function (product) {
            product.$save();
            $scope.editedProduct = null;
        }
        $scope.startEdit = function (product) { $scope.editedProduct = product; }
        $scope.cancelEdit = function () { $scope.editedProduct = null; }
        $scope.listProducts();
    }

})();