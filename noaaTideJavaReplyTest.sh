dave@RUPC:~/codeTacoma$ ls
Client.java                       noaaTideInfoFetch.txt  projectIdeas
noaaTideHighLowInfoFetchJava.txt  noaaTideSoapHL.py      Untitled Document
dave@RUPC:~/codeTacoma$ javac Client.java
dave@RUPC:~/codeTacoma$ java Client

Printing the message that is being sent: 

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"><SOAP-ENV:Body><hilo:getHLPredAndMetadata xmlns:hilo="https://opendap.co-ops.nos.noaa.gov/axis/webservices/highlowtidepred/wsdl"><stationId>8454000</stationId><beginDate>20060921 00:00</beginDate><endDate>20060922 23:59</endDate><datum>MLLW</datum><unit>0</unit><timeZone>0</timeZone></hilo:getHLPredAndMetadata></SOAP-ENV:Body></SOAP-ENV:Envelope>




Iterating through the response object to get the values:


Printing Metadata 

Station ID       : 8454000
station Name     : Providence
Latitude         : 41.8067
Longitude        : -71.4006
State            : RI
Data Source      : USDOC/NOAA/NOS/COOPS(Center for Operational Oceanographic Products and Services)
COOPS Disclaimer : The official Tide and Tidal Current prediction tables are published annually on October 1, for the following calendar year. Tide and Tidal Current predictions generated prior to the publishing date of the official tables are subject to change. The enclosed data are based upon the latest information available as of the date of your request. Tide and Tidal Current predictions generated may differ from the official predictions if information for the station requested has been updated since the publishing date of the official tables.
Begin Date       : 20060921 00:00
End Date         : 20060922 23:59
Datum            : MLLW
Unit             : Feet
Time Zone        : LST

Printing the data 

=======================
09/21/2006
=======================
Time        : 07:08
Pred        : 4.874
Type        : H

Time        : 12:13
Pred        : 0.264
Type        : L

Time        : 19:25
Pred        : 4.586
Type        : H

=======================
09/22/2006
=======================
Time        : 00:36
Pred        : 0.178
Type        : L

Time        : 07:42
Pred        : 4.983
Type        : H

Time        : 12:58
Pred        : 0.156
Type        : L

Time        : 19:57
Pred        : 4.559
Type        : H

dave@RUPC:~/codeTacoma$ javac Client.java
dave@RUPC:~/codeTacoma$ java Client

Printing the message that is being sent: 

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"><SOAP-ENV:Body><hilo:getHLPredAndMetadata xmlns:hilo="https://opendap.co-ops.nos.noaa.gov/axis/webservices/highlowtidepred/wsdl"><stationId>9446484</stationId><beginDate>20170801 00:00</beginDate><endDate>20170830 23:59</endDate><datum>MLLW</datum><unit>0</unit><timeZone>0</timeZone></hilo:getHLPredAndMetadata></SOAP-ENV:Body></SOAP-ENV:Envelope>




Iterating through the response object to get the values:


Printing Metadata 

Station ID       : 9446484
station Name     : Tacoma
Latitude         : 47.27
Longitude        : -122.413
State            : WA
Data Source      : USDOC/NOAA/NOS/COOPS(Center for Operational Oceanographic Products and Services)
COOPS Disclaimer : The official Tide and Tidal Current prediction tables are published annually on October 1, for the following calendar year. Tide and Tidal Current predictions generated prior to the publishing date of the official tables are subject to change. The enclosed data are based upon the latest information available as of the date of your request. Tide and Tidal Current predictions generated may differ from the official predictions if information for the station requested has been updated since the publishing date of the official tables.
Begin Date       : 20170801 00:00
End Date         : 20170830 23:59
Datum            : MLLW
Unit             : Feet
Time Zone        : LST

Printing the data 

=======================
08/01/2017
=======================
Time        : 06:26
Pred        : 1.422
Type        : L

Time        : 13:47
Pred        : 9.11
Type        : H

Time        : 18:46
Pred        : 6.491
Type        : L

=======================
08/02/2017
=======================
Time        : 00:09
Pred        : 10.407
Type        : H

Time        : 07:16
Pred        : 0.873
Type        : L

Time        : 14:52
Pred        : 9.82
Type        : H

Time        : 20:02
Pred        : 6.74
Type        : L

=======================
08/03/2017
=======================
Time        : 00:59
Pred        : 10.186
Type        : H

Time        : 08:02
Pred        : 0.369
Type        : L

Time        : 15:40
Pred        : 10.425
Type        : H

Time        : 21:00
Pred        : 6.713
Type        : L

=======================
08/04/2017
=======================
Time        : 01:46
Pred        : 10.117
Type        : H

Time        : 08:42
Pred        : -0.074
Type        : L

Time        : 16:18
Pred        : 10.859
Type        : H

Time        : 21:44
Pred        : 6.571
Type        : L

=======================
08/05/2017
=======================
Time        : 02:28
Pred        : 10.166
Type        : H

Time        : 09:19
Pred        : -0.447
Type        : L

Time        : 16:49
Pred        : 11.152
Type        : H

Time        : 22:19
Pred        : 6.366
Type        : L

=======================
08/06/2017
=======================
Time        : 03:08
Pred        : 10.282
Type        : H

Time        : 09:55
Pred        : -0.732
Type        : L

Time        : 17:16
Pred        : 11.368
Type        : H

Time        : 22:50
Pred        : 6.084
Type        : L

=======================
08/07/2017
=======================
Time        : 03:46
Pred        : 10.413
Type        : H

Time        : 10:30
Pred        : -0.9
Type        : L

Time        : 17:41
Pred        : 11.563
Type        : H

Time        : 23:19
Pred        : 5.695
Type        : L

=======================
08/08/2017
=======================
Time        : 04:25
Pred        : 10.511
Type        : H

Time        : 11:05
Pred        : -0.9
Type        : L

Time        : 18:07
Pred        : 11.759
Type        : H

Time        : 23:52
Pred        : 5.184
Type        : L

=======================
08/09/2017
=======================
Time        : 05:06
Pred        : 10.528
Type        : H

Time        : 11:42
Pred        : -0.673
Type        : L

Time        : 18:35
Pred        : 11.944
Type        : H

=======================
08/10/2017
=======================
Time        : 00:28
Pred        : 4.561
Type        : L

Time        : 05:50
Pred        : 10.431
Type        : H

Time        : 12:19
Pred        : -0.165
Type        : L

Time        : 19:06
Pred        : 12.083
Type        : H

=======================
08/11/2017
=======================
Time        : 01:08
Pred        : 3.85
Type        : L

Time        : 06:39
Pred        : 10.202
Type        : H

Time        : 12:59
Pred        : 0.652
Type        : L

Time        : 19:39
Pred        : 12.136
Type        : H

=======================
08/12/2017
=======================
Time        : 01:53
Pred        : 3.089
Type        : L

Time        : 07:33
Pred        : 9.853
Type        : H

Time        : 13:41
Pred        : 1.759
Type        : L

Time        : 20:15
Pred        : 12.075
Type        : H

=======================
08/13/2017
=======================
Time        : 02:42
Pred        : 2.319
Type        : L

Time        : 08:34
Pred        : 9.444
Type        : H

Time        : 14:27
Pred        : 3.082
Type        : L

Time        : 20:54
Pred        : 11.896
Type        : H

=======================
08/14/2017
=======================
Time        : 03:37
Pred        : 1.567
Type        : L

Time        : 09:46
Pred        : 9.103
Type        : H

Time        : 15:21
Pred        : 4.481
Type        : L

Time        : 21:38
Pred        : 11.624
Type        : H

=======================
08/15/2017
=======================
Time        : 04:36
Pred        : 0.837
Type        : L

Time        : 11:12
Pred        : 9.044
Type        : H

Time        : 16:28
Pred        : 5.743
Type        : L

Time        : 22:31
Pred        : 11.326
Type        : H

=======================
08/16/2017
=======================
Time        : 05:38
Pred        : 0.118
Type        : L

Time        : 12:47
Pred        : 9.45
Type        : H

Time        : 17:51
Pred        : 6.585
Type        : L

Time        : 23:31
Pred        : 11.103
Type        : H

=======================
08/17/2017
=======================
Time        : 06:41
Pred        : -0.585
Type        : L

Time        : 14:08
Pred        : 10.197
Type        : H

Time        : 19:18
Pred        : 6.801
Type        : L

=======================
08/18/2017
=======================
Time        : 00:35
Pred        : 11.04
Type        : H

Time        : 07:40
Pred        : -1.216
Type        : L

Time        : 15:08
Pred        : 10.963
Type        : H

Time        : 20:30
Pred        : 6.496
Type        : L

=======================
08/19/2017
=======================
Time        : 01:37
Pred        : 11.13
Type        : H

Time        : 08:35
Pred        : -1.681
Type        : L

Time        : 15:55
Pred        : 11.577
Type        : H

Time        : 21:27
Pred        : 5.914
Type        : L

=======================
08/20/2017
=======================
Time        : 02:35
Pred        : 11.275
Type        : H

Time        : 09:26
Pred        : -1.886
Type        : L

Time        : 16:36
Pred        : 12.001
Type        : H

Time        : 22:16
Pred        : 5.221
Type        : L

=======================
08/21/2017
=======================
Time        : 03:30
Pred        : 11.359
Type        : H

Time        : 10:13
Pred        : -1.772
Type        : L

Time        : 17:13
Pred        : 12.253
Type        : H

Time        : 23:00
Pred        : 4.511
Type        : L

=======================
08/22/2017
=======================
Time        : 04:22
Pred        : 11.308
Type        : H

Time        : 10:58
Pred        : -1.321
Type        : L

Time        : 17:48
Pred        : 12.358
Type        : H

Time        : 23:43
Pred        : 3.835
Type        : L

=======================
08/23/2017
=======================
Time        : 05:14
Pred        : 11.096
Type        : H

Time        : 11:41
Pred        : -0.557
Type        : L

Time        : 18:22
Pred        : 12.332
Type        : H

=======================
08/24/2017
=======================
Time        : 00:26
Pred        : 3.229
Type        : L

Time        : 06:06
Pred        : 10.747
Type        : H

Time        : 12:24
Pred        : 0.47
Type        : L

Time        : 18:57
Pred        : 12.173
Type        : H

=======================
08/25/2017
=======================
Time        : 01:09
Pred        : 2.719
Type        : L

Time        : 06:59
Pred        : 10.307
Type        : H

Time        : 13:07
Pred        : 1.685
Type        : L

Time        : 19:32
Pred        : 11.872
Type        : H

=======================
08/26/2017
=======================
Time        : 01:54
Pred        : 2.325
Type        : L

Time        : 07:56
Pred        : 9.835
Type        : H

Time        : 13:52
Pred        : 3.002
Type        : L

Time        : 20:10
Pred        : 11.432
Type        : H

=======================
08/27/2017
=======================
Time        : 02:40
Pred        : 2.054
Type        : L

Time        : 08:58
Pred        : 9.404
Type        : H

Time        : 14:42
Pred        : 4.313
Type        : L

Time        : 20:50
Pred        : 10.88
Type        : H

=======================
08/28/2017
=======================
Time        : 03:30
Pred        : 1.889
Type        : L

Time        : 10:10
Pred        : 9.116
Type        : H

Time        : 15:43
Pred        : 5.484
Type        : L

Time        : 21:35
Pred        : 10.279
Type        : H

=======================
08/29/2017
=======================
Time        : 04:24
Pred        : 1.783
Type        : L

Time        : 11:36
Pred        : 9.113
Type        : H

Time        : 17:01
Pred        : 6.332
Type        : L

Time        : 22:27
Pred        : 9.733
Type        : H

=======================
08/30/2017
=======================
Time        : 05:22
Pred        : 1.659
Type        : L

Time        : 13:03
Pred        : 9.456
Type        : H

Time        : 18:32
Pred        : 6.668
Type        : L

Time        : 23:27
Pred        : 9.373
Type        : H

dave@RUPC:~/codeTacoma$ 

