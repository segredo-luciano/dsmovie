import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/requests";

function Listing() {

    const [pageNumber, setPageNumber] = useState(0);

    const [page, setPage] = useState<MoviePage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 12,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true,
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/movies?size=12&page=${pageNumber}&sort=title`).then(
            movies => {
                const data = movies.data as MoviePage;
                console.log(data);
                setPageNumber(data.number);
                setPage(data)
            }
        )
        // When pageNumber changes, the request is made again
    }, [pageNumber]);

    return (
        <div>
            <Pagination />

            <div className="container">
                <div className="row">
                    {page.content.map(movie => {
                        return (
                            <div key={movie.id} className="col-sm-6 col-lg-4 col-xl-3">
                                <MovieCard movie={movie} />
                            </div>
                        )
                    })}
                </div>
            </div>
        </div>
    )
} export default Listing;