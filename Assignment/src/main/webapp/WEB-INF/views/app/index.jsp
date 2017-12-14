<html data-ng-app="assignmentApp">

<head>

<title>Assignment</title>

<link href="../resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../resources/css/style.css" rel="stylesheet" type="text/css">
<link href="../resources/css/nv.d3.min.css" rel="stylesheet" type="text/css">

<script src="../resources/js/jquery.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script src="../resources/js/angular.js"></script>
<script src="../resources/js/angular-route.js"></script>

<!-- charts -->
<script src="../resources/js/d3.min.js"></script>
<script src="../resources/js/nv.d3.min.js"></script>
<script src="../resources/js/angular-nvd3.js"></script>

<script src="../resources/js/d3-funnel.min.js"></script>

<script src="../resources/js/angular-bootstrap-multiselect-templates.js"></script>
<script src="../resources/js/angular-bootstrap-multiselect.js"></script>
	

<script src="../resources/js/appJs/utility/utility.js"></script>
<script src="../resources/js/appJs/app.js"></script>
<script src="../resources/js/appJs/indexCtrl.js"></script>



</head>

<body ng-controller="indexCtrl">
	<div >
		<div class="padder-v m-b-sm text-center">
		<span class="h4 text-muted ">YEAR ORDERED STATS</span>
		<div class="m-t-xs" ng-if="responseMsg!=''">
		<span ng-bind="responseMsg"></span></div>
		</div>
			<div class="panel panel-default b r m wrapper">
				<div class="panel-heading">	
					<div class="row text-center">
					
					<div class="col-md-3">	
					<label class="control-label">Select Region</label>
						<select ng-model="countrySelected" ng-options="countryOptions as  countryOptions for countryOptions in countryDropDown"></select>
					</div>
					<div class="col-md-3">	
					<label class="control-label">Data for</label>
						<select ng-model="dataFor" ng-options="dataOptions.entityName as  dataOptions.dispName for dataOptions in dataForDropDown"></select>
					</div>
					<div class="col-md-1">					
						<button class="btn btn-primary r-2x" ng-disabled="viewBtnDisable" ng-click="showFilter = !showFilter"> View Stats</button>
					</div>
					<div class="col-md-1">					
						<button class="btn btn-primary r-2x" ng-click="syncStats()" ng-disabled="syncBtnDisable" ng-bind="syncBtnText"> </button>						
					</div>
					
				</div>	
				</div>
				<div class="panel-body">
					<div ng-show="showFilter">
						<div class="row" >
						<div class="col-md-3 "></div>
						<div class="col-md-4 text-center">
						<multiselect ng-model="filterSelection" options="filterOptions" show-search="true" search-limit="10" search-limit="5"></multiselect>
						</div>
						<div class="col-md-2">
						<button class="btn btn-primary r-2x" ng-disabled="viewBtnDisable" ng-click="fetchData()" ng-bind="fetchBtnText"> </button>
						</div>
						</div>
						<div class="row">
						<nvd3 options="statsReportOptions" id="statsTrend"
							data="statsData"></nvd3></div>
					
					</div>
				</div>
			</div>
			
		</div>

	

</body>
</html>
