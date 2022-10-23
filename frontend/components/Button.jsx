import React from "react"
import PlaceList from "./PlaceList"

function Button() {
    const [loading, setLoading] = React.useState(false)
    const [data, setData] = React.useState([])
    const [showData, setShowData] = React.useState(false)
  
    const handleClick = () => {
        setLoading(true);
        setShowData(true)
        const url = "http://localhost:8080/places"
        fetch(url)
            .then((response) => response.json())
            .then((json) => {
                setLoading(false);
                setData(json.data)
            })
        .catch((error) => console.log(error))
    }
    
    return (
      <div>
        <button onClick={handleClick}> Load Data </button>
        {showData ? (
          loading ? (
            <h4>Loading data...</h4>
          ) : (
            <PlaceList places={ data } />
          )
        ) : (
          <div></div>
        )}
      </div>
    )
  }
  
  export default Button