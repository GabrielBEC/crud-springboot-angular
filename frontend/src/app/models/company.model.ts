import { Founder } from "./founder.model";

export interface Company{
    id?: number
    name: string
    location: string
    description: string
    foundedDate: string
    founders: Founder
}