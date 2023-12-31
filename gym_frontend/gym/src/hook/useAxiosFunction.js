import {useState, useEffect} from "react";

const useAxiosFunction = () => {
    const [response, setResponse] = useState([]);
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false); //different!
    const [controller, setController] = useState();

    const axiosFetch = async (configObj) => {
        const {
            axiosInstance,
            method,
            url,
            data,
            callback = () => {
            },
            requestConfig = {}
        } = configObj;
        console.log(configObj);
        try {
            setLoading(true);
            const ctrl = new AbortController();
            setController(ctrl);
            const res = await axiosInstance[method.toLowerCase()](url, data, {
                ...requestConfig,
                signal: ctrl.signal
            });

            callback(res.data);
            setResponse(res.data);
        } catch (err) {
            if (err?.response?.data) {
                callback(null,err?.response?.data);
            } else
                callback(null, err.message);
            setError(err.message);
        } finally {
            setLoading(false);
        }
    }

    useEffect(() => {
        console.log(controller)

        // useEffect cleanup function
        return () => controller && controller.abort();

    }, [controller]);

    return [response, error, loading, axiosFetch];
}

export default useAxiosFunction