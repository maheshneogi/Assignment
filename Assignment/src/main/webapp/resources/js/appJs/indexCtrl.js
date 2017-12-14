app.controller('indexCtrl', [ '$scope','$http','$window','$timeout', function($scope,$http,$window,$timeout) {
	
	
	$scope.countryDropDown = countryDropDown;
	$scope.dataForDropDown = dataForDropDown;
	$scope.dataArray = dataArray;
	
	$scope.reset = function(){
		$scope.syncBtnText = "Sync Stats";
		$scope.fetchBtnText = "Fetch Data";
		$scope.countrySelected = $scope.countryDropDown[0];
		$scope.dataFor = $scope.dataForDropDown[0].entityName;		
		$scope.viewBtnDisable = false;
		$scope.syncBtnDisable = false;
		$scope.responseMsg = "";
		var myData = [];
		$scope.statsData = [];
		$scope.showFilter = false;
		$scope.filterOptions = [];
		$scope.filterSelection = [];
		$scope.getFilterData();
	}
	
	

	

	
$scope.syncStats = function(){
								$scope.syncBtnText = "Syncing..."
								$scope.syncBtnDisable = true;
								$http
										.get(
												"../user/syncStats/?link="
														+ $scope.dataArray[$scope.countrySelected][$scope.dataFor]
														+ "&country="
														+ $scope.countrySelected
														+ "&dataFor="
														+ $scope.dataFor)
										.success(
												function(result) {
													if (result
															.hasOwnProperty("responseMsg")) {
														$scope.responseMsg = result.responseMsg;
														$scope.syncBtnText = "Sync Stats";
														$scope.syncBtnDisable = false;
														$timeout(
																function() {
																	$scope.responseMsg = "";
																}, 2000);
													}

												}).error(function(errorMsg){
													$scope.syncBtnText = "Sync Data";
													$scope.syncBtnDisable = false;
												});
	
	
}

$scope.statsReportOptions = {
		chart : {
			type : 'lineChart',
			useInteractiveGuideline : true,
			tooltips : true,
			interactive : true,
			showLegend : false,
			height : 500,
			margin : {
				top : 20,
				right : 40,
				bottom : 70,
				left : 70
			},
			duration : 50,

			xAxis : {
				axisLabel : ('Data'),
				tickFormat : function (d) { 
					return myData[d];
				},
			rotateLabels : -25
			},
			yAxis : {
				axisLabel : ('Value'),
				tickFormat : function(d) {
					return d ;
				},
			},
			
			tooltip : function(key, x, y, e, graph) {

				return '<p>' + key + '</p>' + '<p>' + y + ' for ' + x + '</p>';
			},
		}
	};


	$scope.viewStats = function()
	{
		
		if($scope.filterSelection.length>0)
			{
			$scope.fetchBtnText="Fetching..."
		$http
		.get(
				"../user/viewStats/?country="
						+ $scope.countrySelected
						+ "&dataFor="
						+ $scope.dataFor+"&year="+  window.encodeURIComponent(JSON.stringify($scope.statsFilter)))
		.success(
				function(result) {
					if (result.hasOwnProperty("dataForGraph") && result.hasOwnProperty("xAxisMap")) {						
						
						$scope.statsData = result.dataForGraph;
						console.log($scope.statsData )
						myData = result.xAxisMap;
						$scope.fetchBtnText = "Fetch Data";
					}
					else
						{
						$scope.statsData = [];						
						myData = [];
						$scope.fetchBtnText = "Fetch Data";
						
						}

				}).error(function(error){
					$scope.viewBtnDisable = false;
				});
			}
		else
			alert("select at least one filter ");
	}
	
	$scope.fetchData = function()
	{
	$scope.statsFilter=[{
		"colName" : "Year",
		"colValue" : $scope.filterSelection,
		"dataType" : "Integer"
	}];
	$scope.viewStats();
	}
	
	$scope.getFilterData = function(){
		$http
		.get(
				"../user/getFilterData/?country="
						+ $scope.countrySelected
						+ "&dataFor="
						+ $scope.dataFor)
		.success(
				function(result) {
					if (result.hasOwnProperty("filterData")) {						
						
						$scope.filterOptions = result.filterData;
						
					}

				}).error(function(error){
					$scope.viewBtnDisable = false;
				});
	}
	
	$scope.reset();
	

}]);