# Web page
Show list of 3 example price feeds (HBAR, Amazon, Roblox) to an employee. Those values are read from Pyth

Prompt used to create this web page (then fixed and tweaked manually)
```
Create a simple html web page, using a professional theme, like a business report from a financial enterprise. Add the header "Dear employee Jhon, here are your possible investment options"

Uploading the web page must call an example https API using the get method. The result of that API is a json with the format below

"""
{
   "parsed":[
      {
         "id":"3728e591097635310e6341af53db8b7ee42da9b3a8d918f9463ce9cca886dfbd",
         "price":{
            "price":"13367656",
            "conf":"12545",
            "expo":-8,
            "publish_time":1763863839
         }
      },
      {
         "id":"b5d0e0fa58a1f8b81498ae670ce93c872d14434b72c364885d4fa1b257cbb07a",
         "price":{
            "price":"22066100",
            "conf":"40106",
            "expo":-5,
            "publish_time":1763758819
         }
      },
      {
         "id":"d62134a195739141d0649991f11fe0f9cd9eb83fd890bc3ba41dfdd18c1a49f4",
         "price":{
            "price":"8924510",
            "conf":"9705",
            "expo":-5,
            "publish_time":1763758820
         }
      }
   ]
}
"""

Please show the results of the API call in a nice formatted table. Each element of the "parsed" array will be a row in the table. Use three columns: type of asset, name of asset, value in USD.

The id "3728e591097635310e6341af53db8b7ee42da9b3a8d918f9463ce9cca886dfbd" is an asset of type "crypto" and name "Hedera HBAR".

The id "b5d0e0fa58a1f8b81498ae670ce93c872d14434b72c364885d4fa1b257cbb07a" is an asset of type "equity" and name "Amazon".

The id "d62134a195739141d0649991f11fe0f9cd9eb83fd890bc3ba41dfdd18c1a49f4" is an asset of type "equity" and name "Roblox".

Inside the price column, put the value of the "price" attribute, but insert a dot in the position especified by the "expo" attribute, start to count from the last character, then moving to the left

```
