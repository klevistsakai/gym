import axios from '../api/gym';
import { useState, useEffect } from "react";

const Service = (configObj) => {
    const {
        method,
        url,
        data,
        requestConfig
    } = configObj;

    const [response, setResponse] = useState([]);
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(true);
    const [reload, setReload] = useState(0);

    const refetch = () => setReload(prev => prev + 1);
    
    useEffect(() => {
        //let isMounted = true;
        const controller = new AbortController();

        const fetchData = async () => {
            try {
                const res = await axios[method.toLowerCase()](url, data, {
                    ...{
                        headers: {
                            'Content-Language': 'en-US',
                            //'Accept': 'text/html'
                        },
                        signal: controller.signal
                    }, ...requestConfig
                });
                setResponse(res.data);
            } catch (err) {

                setError(err.message);
            } finally {
                setLoading(false);
            }
        }

        // call the function
        fetchData();

        // useEffect cleanup function
        return () => controller.abort();

        // eslint-disable-next-line
    }, [reload]);

    return [response, error, reload, refetch];
}

export default Service