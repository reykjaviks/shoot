import React from "react"
import Place from "./Place"

export default function PlaceList({ places = [] }) {
    if(!places.length) return <div>Could not find any places</div>
    return (
        <div>
            { places.map(place => <Place key={place.id} {...place} />) }
        </div>
    )
}