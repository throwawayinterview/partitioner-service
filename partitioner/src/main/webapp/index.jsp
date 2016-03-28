<html>
<body>
    <h1>Partition Rest API</h1>
    <h2>Partitions a group of numbers into subgroups given a maxSum</h2>
    <p><b>URL Endpoint</b>: <a href="#">webapi/partition</a>
    <p><b>HTTP method</b>: GET
    <p><b>Header params</b>: 
    <ul>
    	<li><b>values</b> : comma separated list of doubles. example "1.0,2.0,3.0,4.0,5"</li>
    	<li><b>maxSum</b> : maximum sum of the subgroup. example 5</li>
    	<li><b>algo</b> : [optional] you can suggest an algo to use. Available algos are "random", "greedy", "oneToOne", "sortedGreedy" or "reverseSortedGreedy". Defaults to "greedy"</li>
    </ul>
    <p> Returns JSON. 
    Sample output:
    <p>[{"id":0,"values":[5.0,5.0]},{"id":1,"values":[5.0]},{"id":2,"values":[6.0]},{"id":3,"values":[9.0]},{"id":4,"values":[4.0]},{"id":5,"values":[6.0]},{"id":6,"values":[7.0]}]
    
</body>
</html>
