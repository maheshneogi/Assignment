
var countryDropDown = ["UK","England", "Wales", "Scotland"];

var dataForDropDown = [ {
	"dispName" : "Max Temp",
	"entityName" : "MaxTemp"
},{
	"dispName" : "Min Temp",
	"entityName" : "MinTemp"
},{
	"dispName" : "Mean Temp",
	"entityName" : "MeanTemp"
	
},{
	"dispName" : "Sunshine",
	"entityName" : "Sunshine"
	
},{
	"dispName" : "Rainfall",
	"entityName" : "Rainfall"
	
} ];


var dataArray = {
		"UK" : {
			"MaxTemp" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmax/date/UK.txt",
			"MinTemp" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmin/date/UK.txt",
			"MeanTemp" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmean/date/UK.txt",
			"Sunshine" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Sunshine/date/UK.txt",
			"Rainfall" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Rainfall/date/UK.txt"
		},		
		"England" : {
			"MaxTemp" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmax/date/England.txt",
			"MinTemp" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmin/date/England.txt",
			"MeanTemp" : "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmean/date/England.txt",
			"Sunshine" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Sunshine/date/England.txt",
			"Rainfall" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Rainfall/date/England.txt"
		},
		"Wales" : {
			"MaxTemp" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmax/date/Wales.txt",
			"MinTemp" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmin/date/Wales.txt",
			"MeanTemp" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmean/date/Wales.txt",
			"Sunshine" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Sunshine/date/Wales.txt",
			"Rainfall" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Rainfall/date/Wales.txt"
		},
		"Scotland" : {
		"MaxTemp" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmax/date/Scotland.txt",
		"MinTemp" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmin/date/Scotland.txt",
		"MeanTemp" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmean/date/Scotland.txt",
		"Sunshine" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Sunshine/date/Scotland.txt",
		"Rainfall" : "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Rainfall/date/Scotland.txt"
	}
}