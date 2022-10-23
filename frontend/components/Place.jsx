import React from "react"

export default function Place({ info_url, name_fi }) {
    return (
        <section>
            <h3>{ name_fi }</h3>
            <p>{ info_url }</p>
        </section>
    )
}