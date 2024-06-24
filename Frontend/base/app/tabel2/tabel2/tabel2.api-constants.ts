import { Tabel2Base} from '@baseapp/tabel2/tabel2/tabel2.base.model';

export class Tabel2ApiConstants {
    public static readonly autoSuggestService: any = {
        url: '/rest/tabel2s/autosuggest',
        method: 'GET',
        showloading: true
    };
    public static readonly update: any = {
        url: '/rest/tabel2s/',
        method: 'PUT',
        showloading: true
    };
    public static readonly getById: any = {
        url: '/rest/tabel2s/{sid}',
        method: 'GET',
        showloading: true
    };
    public static readonly getBytablw2_p_keyIndex: any = {
        url: '/rest/tabel2s/getbytablw2_p_key/{field2}',
        method: 'GET',
        showloading: true
    };
    public static readonly create: any = {
        url: '/rest/tabel2s/',
        method: 'POST',
        showloading: true
    };
    public static readonly blanksNameCreateopentab2: any = {
        url: '/rest/tabel2s/blanksname/createopentab2/{id}',
        method: 'PUT',
        showloading: true
    };
    public static readonly delete: any = {
        url: '/rest/tabel2s/{ids}',
        method: 'DELETE',
        showloading: true
    };
    public static readonly getDatatableData: any = {
        url: '/rest/tabel2s/datatable',
        method: 'POST',
        showloading: true
    };
}