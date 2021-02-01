interface VehicleResponse {
    id: string,
    name: string,
    brand: string,
    year: number,
    description?: string,
    isSold: boolean,
    createdAt: Date
}