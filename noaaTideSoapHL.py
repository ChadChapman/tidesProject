from zeep import Client

client = ("https://opendap.co-ops.nos.noaa.gov/axis/webservices/highlowtidepred/wsdl")
client.service.submit_order(user_id = 1, order = {
    'stationId': '9446484', #first Tacoma station id found with quick search
    'beginDate': '20060920 00:00',
    'endDate': '20060922 23:59',
    'datum': 'MLLW',
    'unit': '0',
    'timeZone': '0',

})